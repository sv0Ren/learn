package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
public class TestBackendApplication {

	@RequestMapping("/")
	public String home(Principal user) {
		return "Hello lala" + user.getName();
	}


	public static void main(String[] args) {
		SpringApplication.run(TestBackendApplication.class, args);
	}

}