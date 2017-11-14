package com.controller.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertyManager {

    @Autowired
    private Environment env;

    public String getHostUrl() {
        return env.getProperty("host.url");
    }

    public String getUserBackendPort() {
        return env.getProperty("userbackend.port");
    }

    public String getUserBackendUrl() {
        return getHostUrl() +":" +getUserBackendPort() + "/";
    }
}