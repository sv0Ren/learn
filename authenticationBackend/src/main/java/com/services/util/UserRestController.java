package com.services.util;

import com.models.AuthUser;
import constants.Constants;
import interfaces.UserInterface;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRestController extends SimpleRestController implements UserInterface {

    @Autowired
    private String userBackend;

    @Override
    public User get(String typ, String identifier) {
        String endpointUrl = userBackend + "user/{typ}/{identifier}/";
        return get(endpointUrl, User.class, typ, identifier);
    }

    @Override
    public void create(User newUser) {
        post(userBackend + "user", newUser, User.class);
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
