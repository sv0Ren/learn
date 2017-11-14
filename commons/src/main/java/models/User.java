package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public String id;
    public String firstName;
    public String lastName;
    public String mail;
    public String tel;
    public String userName;
    public String accountPrimary;
}