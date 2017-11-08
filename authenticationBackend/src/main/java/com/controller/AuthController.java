package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


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

        }
        return principal;
    }

}
