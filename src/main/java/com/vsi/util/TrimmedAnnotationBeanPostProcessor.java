package com.vsi.util;

import com.vsi.custombeanpostprocessor.annotation.Trimmed;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.util.Arrays;

public class TrimmedAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = bean.getClass();

        if (type.isAnnotationPresent(Trimmed.class)) {
            Enhancer enhancer = new Enhancer();

            enhancer.setSuperclass(type);
            enhancer.setInterfaces(type.getInterfaces());

            MethodInterceptor methodInterceptor = (o, method, objects, methodProxy) -> {
                Object result = methodProxy.invokeSuper(o, Arrays
                    .stream(objects)
                    .map(object -> object.getClass().equals(String.class)
                        ? ((String) object).trim()
                        : object
                    )
                    .toArray()
                );

                if (method.getReturnType().equals(String.class)) {
                    return ((String)result).trim();
                }

                return result;
            };

            enhancer.setCallback(methodInterceptor);

            return type.cast(enhancer.create());
        }

        return bean;
    }
}
