package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PropertyBeans {

    @Autowired
    private Environment env;

    @Bean
    public String HOST_URL() {
        return env.getProperty("host.url");
    }

    @Bean
    public String USER_BACKEND_PORT() {
        return env.getProperty("userbackend.port");
    }

    @Bean
    public String USER_BACKEND() {
        return HOST_URL() +":" + USER_BACKEND_PORT() + "/";
    }
}