package com.controller;

import com.model.MyUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.LinkedHashMap;


@RestController
@RequestMapping("/user")
public class AuthController {


    @GetMapping()
    public Principal user(Principal principal) {

        if (principal instanceof OAuth2Authentication) {
            Authentication userAuthentication = ((OAuth2Authentication) principal).getUserAuthentication();
            LinkedHashMap userDetails = (LinkedHashMap) userAuthentication.getDetails();
            String userName = (String) userDetails.get("name");
            String userMail = (String) userDetails.get("email");
            String userId = (String) userDetails.get("id");

            MyUser newUser = new MyUser(userName, userMail, userId);

            RestTemplate restTemplate = new RestTemplate();

            restTemplate.postForEntity("http://localhost:8081/user", newUser, MyUser.class);



            MyUser user = restTemplate.getForObject("http://localhost:8081/user/", MyUser.class);

        }



        return principal;
    }

}
