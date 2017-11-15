package com.services;

import java.util.List;

import com.models.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoService extends MongoRepository<MongoUser, String> {

    public MongoUser findByAccountPrimary(String accountPrimary);

    public MongoUser findByUserName(String userName);

    public MongoUser findByMail(String mail);

    public MongoUser findByFirstName(String firstName);

    public List<MongoUser> findByLastName(String lastName);

}