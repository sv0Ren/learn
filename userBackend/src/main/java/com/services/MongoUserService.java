package com.services;

import java.util.List;

import com.models.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserService extends MongoRepository<MongoUser, String> {

    public MongoUser deleteByMail(String mail);

    public MongoUser findByAccountPrimary(String accountPrimary);

    public MongoUser findByUserName(String userName);

    public MongoUser findByMail(String mail);

}