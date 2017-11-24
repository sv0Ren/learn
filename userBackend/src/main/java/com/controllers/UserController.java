package com.controllers;


import com.models.MongoUser;
import com.framwork.rest.services.MongoUserService;
import to.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController implements UserRestService {

    @Autowired
    private MongoUserService mongoUserService;

    @Override
    @PostMapping()
    public void post(@RequestBody User user) {
        MongoUser mongoUser = new MongoUser(user);
        mongoUserService.save(mongoUser);
    }

    @Override
    @DeleteMapping(value="/{identifier}/")
    public void delete(@PathVariable String identifier){
        if(identifier.contains("@")){
            mongoUserService.deleteByMail(identifier);
        }
        mongoUserService.delete(identifier);
    }

    @Override
    @PutMapping
    public void put(@RequestBody User newUser){
        MongoUser oldUser = mongoUserService.findOne(newUser.getId());
        MongoUser mongoUser = new MongoUser(newUser);
        if(oldUser != null){
            mongoUser.setId(oldUser.getId());
        }
        mongoUserService.save(mongoUser);
    }

    @Override
    @GetMapping(value={"/{identifier}/"})
    public User get(@PathVariable String identifier){

        User user = null;

        if(identifier.contains("@")){
           user = mongoUserService.findByMail(identifier);
        }
        if(user == null){
            user = mongoUserService.findByUserName(identifier);
        }
        if(user == null){
            user = mongoUserService.findByAccountPrimary(identifier);
        }
        if(user == null){
            user = mongoUserService.findOne(identifier);
        }

        return user;
    }

    @Override
    @GetMapping(value="")
    public List<User> get(){
        List<MongoUser> userCollectionList = mongoUserService.findAll();
        List<User> userList = new ArrayList<User>();
        for(MongoUser userCollection : userCollectionList){
            userList.add((User) userCollection);
        }
        return userList;
    }
}
