package com.services;

import java.util.List;

import com.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserService extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);

}