package com.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController{


    @Autowired
    private _UserRepo userRepo;

//    @Autowired
//    private UserService userService;

    private User testUser = new User("deine","mudda");

    @PostMapping()
    public User create(@RequestBody User user) {
        return userRepo.save(testUser);
    }

    @GetMapping(value="/{userId}")
    public User get(@PathVariable String userId){
        return userRepo.findOne(userId);
    }

    @GetMapping(value="")
    public List<User> getAll(){
        return userRepo.findAll();
    }
}
