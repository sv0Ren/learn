package com.services;

import com.services.utils.RestService;
import interfaces.UserBackendInterface;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends RestService implements UserBackendInterface {

    @Autowired
    private String USER_BACKEND;

    @Override
    public User get(String typ, String identifier) {
        String endpointUrl = USER_BACKEND + "user/{typ}/{identifier}/";
        return get(endpointUrl, User.class, typ, identifier);
    }

    @Override
    public void create(User newUser) {
        post(USER_BACKEND + "user", newUser, User.class);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(String userId) {

    }

    @Override
    public void update(User newUser) {

    }


    @Override
    public User get(String userId) {
        return null;
    }

    @Override
    public User getByIdentifier(String typ, String identifier) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
