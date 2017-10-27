package com.controller;


import com.model.User;
import com.services.UserService;
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
        userService.delete(user.id);
    }

    @PutMapping
    public void update(@RequestBody User newUser){
        User oldUser = userService.findOne(newUser.id);
        if(oldUser != null){
            newUser.id = oldUser.id;
            userService.save(newUser);
        }
    }

    @GetMapping(value="/{userId}")
    public User get(@PathVariable String userId){
        return userService.findOne(userId);
    }

    @GetMapping(value="")
    public List<User> getAll(){
        return userService.findAll();
    }
}
