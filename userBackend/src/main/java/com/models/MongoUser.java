package com.models;

import models.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class MongoUser extends models.User{

    @Id
    public String id;

    public MongoUser(){}

    public MongoUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MongoUser(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MongoUser(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.mail = user.mail;
        this.tel = user.tel;
        this.userName = user.userName;
        this.accountPrimary = user.accountPrimary;
    }

}