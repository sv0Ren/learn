package com.controller;


import com.model.User;
import com.services.UserService;
import constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping()
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping()
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @DeleteMapping(value="/{userId}")
    public void delete(@PathVariable String userId){
        userService.delete(userId);
    }

    @PutMapping
    public void update(@RequestBody User newUser){
        User oldUser = userService.findOne(newUser.id);
        if(oldUser != null){
            newUser.id = oldUser.id;
            userService.save(newUser);
        }
    }

    @GetMapping(value="/{typ}")
    public User get(@PathVariable String typ, @RequestBody String identifier){

        if(typ.equals(Constants.MAIL)){
            return userService.findByMail(identifier);
        }
        if(typ.equals(Constants.ID)){
            return userService.findOne(identifier);
        }

        return null;
    }

    @GetMapping(value="/id/{userId}")
    public User get(@PathVariable String userId){
        return userService.findOne(userId);
    }

    @GetMapping(value={"/{typ}/{identifier}/"})
    public User getByIdentifier(@PathVariable String typ, @PathVariable String identifier){

        if(typ.equals(Constants.MAIL)){
            return userService.findByMail(identifier);
        }
        if(typ.equals(Constants.ID)){//NEVER USED
            return userService.findOne(identifier);
        }

        return null;
    }

    @GetMapping(value="")
    public List<User> getAll(){
        return userService.findAll();
    }
}
