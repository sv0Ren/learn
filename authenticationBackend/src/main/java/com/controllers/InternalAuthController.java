package com.controllers;

import com.models.AuthUser;
import com.framwork.rest.services.GenericRestService;
import com.framwork.rest.annotationBeans.InjectRestService;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import to.User;

import java.security.Principal;
import java.util.LinkedHashMap;


@RestController
@RequestMapping("/user")
public class InternalAuthController {

    @InjectRestService(to = User.class)
    private GenericRestService<User> userService;

    @GetMapping()
    public Principal user(Principal principal) {

        if (!(principal instanceof OAuth2Authentication)){
            return null;
        }

        User user = null;

        Authentication userAuthentication = ((OAuth2Authentication) principal).getUserAuthentication();
        LinkedHashMap userDetails = (LinkedHashMap) userAuthentication.getDetails();
        String userName = (String) userDetails.get("name");
        String userMail = (String) userDetails.get("email");
        String accountId = (String) userDetails.get("id");

        if(userMail != null && userMail.contains("@")){
            user = userService.get(userMail);
        }

        if(user == null){
            AuthUser newUser = new AuthUser(userName, userMail, accountId);
            userService.post(newUser);
        }

        return principal;
    }

}
