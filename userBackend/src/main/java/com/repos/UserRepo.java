package com.repos;

import java.util.List;

import com.models.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<MongoUser, String> {

    public MongoUser findByMail(String mail);

    public MongoUser findByFirstName(String firstName);

    public List<MongoUser> findByLastName(String lastName);

}