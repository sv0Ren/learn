package com.controller.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestController extends PropertyManager{

    @Autowired
    private RestTemplate restTemplate;

    protected <T> ResponseEntity<T> post(String url, Object request, Class<T> responseType) {
        return restTemplate.postForEntity(url, request, responseType);
    }

    public <T> T get(String url, Class<T> responseType, Map<String, String> uriVariables){
        return restTemplate.getForObject(url, responseType, uriVariables);
    }

}
