package com.framwork.rest.annotationBeans;

import com.framwork.rest.annotationBeans.util.EndpointProperties;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.*;

public class RestServiceFieldCallback implements ReflectionUtils.FieldCallback {

    private ConfigurableListableBeanFactory configurableBeanFactory;
    private Object bean;

    private static int AUTOWIRE_MODE = AutowireCapableBeanFactory.AUTOWIRE_BY_NAME;

    public RestServiceFieldCallback(ConfigurableListableBeanFactory bf, Object bean) {
        configurableBeanFactory = bf;
        this.bean = bean;
    }

    @Override
    public void doWith(Field field)
            throws IllegalArgumentException, IllegalAccessException {
        if (!field.isAnnotationPresent(InjectRestService.class)) {
            return;
        }
        ReflectionUtils.makeAccessible(field);
        Type fieldGenericType = field.getGenericType();


        Class<?> service = field.getType();
        Class<?> to = field.getDeclaredAnnotation(InjectRestService.class).to();

        if (genericTypeIsValid(to, fieldGenericType)) {
            String beanName = to.getSimpleName() + service.getSimpleName();
            Object beanInstance = getBeanInstance(beanName, service, to);
            field.set(bean, beanInstance);

            String endpoint = getEndpoint(to);
            setServiceEndpoint(beanInstance, endpoint);

        } else {
            //throw new IllegalArgumentException(ERROR_ENTITY_VALUE_NOT_SAME);
        }
    }

    private String getEndpoint(Class<?> to) {
        EndpointProperties endpoints  = EndpointProperties.getInstanz();

        String endpoint = null;
        try {
            endpoint = endpoints.getEndpointByTO(to);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            //throw new IllegalArgumentException(ERROR_UNKNOWN_ENDPOINT);
        }

        return endpoint;
    }

    private void setServiceEndpoint(Object beanInstance, String endpoint) {
        try {
            beanInstance.getClass().getField("endpoint").set(beanInstance, endpoint);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            //throw new IllegalArgumentException(ERROR_SETTING_ENDPOINT_FAILED);
        }
    }

    private boolean genericTypeIsValid(Class<?> clazz, Type field) {
        if (field instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) field;
            Type type = parameterizedType.getActualTypeArguments()[0];
            return type.equals(clazz);
        } else {
            return true;
        }
    }

    private Object getBeanInstance(
            String beanName, Class<?> genericClass, Class<?> paramClass) {
        Object serviceInstance = null;
        if (!configurableBeanFactory.containsBean(beanName)) {

            Object toRegister = null;
            try {
                Constructor<?> ctr = genericClass.getConstructor(Class.class);
                toRegister = ctr.newInstance(paramClass);
            } catch (Exception e) {
                //logger.error(ERROR_CREATE_INSTANCE, genericClass.getTypeName(), e);
                throw new RuntimeException(e);
            }

            serviceInstance = configurableBeanFactory.initializeBean(toRegister, beanName);
            configurableBeanFactory.autowireBeanProperties(serviceInstance, AUTOWIRE_MODE, true);
            configurableBeanFactory.registerSingleton(beanName, serviceInstance);
            //logger.info("Bean named '{}' created successfully.", beanName);
        } else {
            serviceInstance = configurableBeanFactory.getBean(beanName);
            //logger.info("Bean named '{}' already exists used as current bean reference.", beanName);
        }
        return serviceInstance;
    }

}
