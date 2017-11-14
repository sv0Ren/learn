package com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ControllerBeans {

    @Bean
    protected RestTemplate RestTemplate(){
        return new RestTemplate();
    }
}
