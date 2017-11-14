package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {

    //@Getter(AccessLevel.NONE)
    //@Setter(AccessLevel.NONE)
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String mail;
    protected String tel;
    protected String userName;
    protected String accountPrimary;
}