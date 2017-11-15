package com.controllers;


import com.models.MongoUser;
import com.services.UserMongoService;
import constants.UserConstants;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserMongoService userService;

    @PostMapping()
    public void create(@RequestBody User user) {
        MongoUser mongoUser = new MongoUser(user);
        userService.save(mongoUser);
    }

    @DeleteMapping()
    public void delete(@RequestBody User user) {
        MongoUser mongoUser = new MongoUser(user);
        userService.delete(mongoUser);
    }

    @DeleteMapping(value="/{userId}")
    public void delete(@PathVariable String userId){
        userService.delete(userId);
    }

    @PutMapping
    public void update(@RequestBody User newUser){
        MongoUser oldUser = userService.findOne(newUser.getId());
        if(oldUser != null){
            newUser.setId(oldUser.getId());
            MongoUser mongoUser = new MongoUser(newUser);
            userService.save(mongoUser);
        }
    }


    @GetMapping(value={"/{identifier}/"})
    public User get(@PathVariable String identifier){

        User user = null;

        if(identifier.contains("@")){
           user = userService.findByMail(identifier);
        }
        if(user == null){
            user = userService.findByUserName(identifier);
        }
        if(user == null){
            user = userService.findByAccountPrimary(identifier);
        }
        if(user == null){
            user = userService.findOne(identifier);
        }

        return user;
    }

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
