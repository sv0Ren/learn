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
    public String hostUrl() {
        return env.getProperty("host.url");
    }

    @Bean
    public String userBackendPort() {
        return env.getProperty("userbackend.port");
    }

    @Bean
    public String userBackend() {
        return hostUrl() +":" + userBackendPort() + "/";
    }
}