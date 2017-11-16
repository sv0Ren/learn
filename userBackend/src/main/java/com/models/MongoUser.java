package com.models;

import lombok.Data;
import to.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="users")
public class MongoUser extends User{

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
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.mail = user.getMail();
        this.tel = user.getTel();
        this.userName = user.getUserName();
        this.accountPrimary = user.getAccountPrimary();
    }

}