package com.models;

public class AuthUser extends models.User{

    public AuthUser(String userName, String mail, String accountPrimary) {
        this.mail = mail;
        this.userName = userName;
        this.accountPrimary = accountPrimary;
    }

}
