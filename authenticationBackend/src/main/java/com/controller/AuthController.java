package com.controller;

import com.model.MyUser;
import constants.Constants;
import models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class AuthController extends com.controller.utils.RestController{


    @GetMapping()
    public Principal user(Principal principal) {

        String backend = getUserBackendUrl();

        User user = null;

        if (principal instanceof OAuth2Authentication) {
            Authentication userAuthentication = ((OAuth2Authentication) principal).getUserAuthentication();
            LinkedHashMap userDetails = (LinkedHashMap) userAuthentication.getDetails();
            String userName = (String) userDetails.get("name");
            String userMail = (String) userDetails.get("email");
            String accountId = (String) userDetails.get("id");

            if(userMail != null && userMail.contains("@")){
                String endpointUrl = backend + "user/{typ}/{identifier}/";

                Map<String, String> variables = new HashMap<String, String>(3);
                variables.put("typ", Constants.MAIL);
                variables.put("identifier", userMail);

                user = get(endpointUrl, User.class, variables);
            }

            MyUser newUser = new MyUser(userName, userMail, accountId);
            post(backend + "user", newUser, User.class);
        }

        return principal;
    }

}
