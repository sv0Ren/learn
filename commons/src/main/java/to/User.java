package to;

import lombok.Data;

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