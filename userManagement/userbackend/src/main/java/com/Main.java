package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
//@ComponentScan
public class Main {

//    @RequestMapping("/")
//    public String home() {
//        return "Hello Docker World";
//    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
