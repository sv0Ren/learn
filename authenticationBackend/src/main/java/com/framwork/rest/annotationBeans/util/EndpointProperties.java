package com.framwork.rest.annotationBeans.util;

import com.AuthenticationBackendApplication;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class EndpointProperties {

    private static EndpointProperties instance;

    private Properties properties;

    public static EndpointProperties getInstanz() {
        if(instance == null){
            return new EndpointProperties();
        }
        return instance;
    }

    private EndpointProperties(){
        this.properties = new Properties();

        //TODO: verweis auf application.properties vom gesammtsystem (global)
        try (InputStream is = AuthenticationBackendApplication.class.getClassLoader().getResourceAsStream("application.properties")) {

        //try (InputStream is = getClass().getClassLoader().getResourceAsStream("global.properties")) {

                properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String HOST_URL() {
        return properties.getProperty("host.url");
    }

    public String USER_BACKEND_PORT() {
        return properties.getProperty("userbackend.port");
    }

    public String USER_BACKEND() {
        return HOST_URL() +":" + USER_BACKEND_PORT() + "/";
    }

    public String getEndpointByTO(Class<?> to) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String simpleName = to.getSimpleName();
        Method method = this.getClass().getMethod(simpleName.toUpperCase()+"_BACKEND");
        return (String) method.invoke(this) + simpleName.toLowerCase() + "/";
    }
}