package com.controllers;


import com.models.MongoUser;
import com.services.UserMongoService;
import constants.UserConstants;
import interfaces.UserBackendInterface;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController implements UserBackendInterface {

    @Autowired
    private UserMongoService userService;

    @Override
    @PostMapping()
    public void create(@RequestBody User user) {
        MongoUser mongoUser = new MongoUser(user);
        userService.save(mongoUser);
    }

    @Override
    @DeleteMapping()
    public void delete(@RequestBody User user) {
        MongoUser mongoUser = new MongoUser(user);
        userService.delete(mongoUser);
    }

    @Override
    @DeleteMapping(value="/{userId}")
    public void delete(@PathVariable String userId){
        userService.delete(userId);
    }

    @Override
    @PutMapping
    public void update(@RequestBody User newUser){
        MongoUser oldUser = userService.findOne(newUser.getId());
        if(oldUser != null){
            newUser.setId(oldUser.getId());
            MongoUser mongoUser = new MongoUser(newUser);
            userService.save(mongoUser);
        }
    }

    @Override
    @GetMapping(value="/{typ}")
    public User get(@PathVariable String typ, @RequestBody String identifier){

        if(typ.equals(UserConstants.MAIL)){
            return userService.findByMail(identifier);
        }
        if(typ.equals(UserConstants.ID)){
            return userService.findOne(identifier);
        }

        return null;
    }

    @Override
    @GetMapping(value="/id/{userId}")
    public User get(@PathVariable String userId){
        return userService.findOne(userId);
    }

    @Override
    @GetMapping(value={"/{typ}/{identifier}/"})
    public User getByIdentifier(@PathVariable String typ, @PathVariable String identifier){

        if(typ.equals(UserConstants.MAIL)){
            return userService.findByMail(identifier);
        }
        if(typ.equals(UserConstants.ID)){//NEVER USED
            return userService.findOne(identifier);
        }

        return null;
    }

    @Override
    @GetMapping(value="")
    public List<User> getAll(){
        List<MongoUser> userCollectionList = userService.findAll();
        List<User> userList = new ArrayList<User>();
        for(MongoUser userCollection : userCollectionList){
            userList.add((User) userCollection);
        }
        return userList;
    }
}
