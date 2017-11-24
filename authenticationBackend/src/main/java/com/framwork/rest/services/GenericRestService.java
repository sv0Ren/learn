package com.framwork.rest.services;

import com.framwork.rest.services.utils.RestTemplateAdapter;
import interfaces.RestService;

import java.util.List;


public class GenericRestService<T> extends RestTemplateAdapter implements RestService<T>{

    public String endpoint;

    private final Class<T> type;

    public GenericRestService(Class<T> type) {
        this.type = type;
    }

    @Override
    public void delete(String identifier) {

    }

    @Override
    public void put(Object object) {}

    @Override
    public List get() {
        return null;
    }

    @Override
    public T get(String identifier) {
        return get(endpoint + "{identifier}/", type, identifier);
    }

    @Override
    public void post(T object) {
        post(endpoint, object, type);
    }

}
