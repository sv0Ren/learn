package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
//@ComponentScan
public class UserBackendApplication {

//    @RequestMapping("/")
//    public String home() {
//        return "Hello Docker World";
//    }

    public static void main(String[] args) {
        SpringApplication.run(UserBackendApplication.class, args);
    }

}
