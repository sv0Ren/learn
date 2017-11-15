package com.services;

import com.services.utils.RestService;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends RestService {

    @Autowired
    private String USER_BACKEND;

    public User get(String identifier) {
        return get(USER_BACKEND + "user/{identifier}/", User.class, identifier);
    }

    public void post(User newUser) {
        post(USER_BACKEND + "user", newUser, User.class);
    }

}
