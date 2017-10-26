package com.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController{


    @Autowired
    private _UserRepo userRepo;

//    @Autowired
//    private UserService userService;

    private User testUser = new User("deine","mudda");



    @PostMapping("/user")
    //@RequestMapping(method = RequestMethod.POST, value = "/")
    public User create(@RequestBody User user) {
        return userRepo.save(testUser);
    }

    /*


    @RequestMapping(method = RequestMethod.GET, value = "/{user}")
    public User get(@PathVariable String user) {
        return userRepo.findOne(user);
    }*/
}
