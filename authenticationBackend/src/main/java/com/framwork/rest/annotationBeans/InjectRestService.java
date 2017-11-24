package com.framwork.rest.annotationBeans;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.TYPE})
//@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Documented
public @interface InjectRestService {
    Class<?> to();
}


