package com.models;

public class AuthUser extends to.User{

    public AuthUser(String userName, String mail, String accountPrimary) {
        this.mail = mail;
        this.userName = userName;
        this.accountPrimary = accountPrimary;
    }

}
