package com.vsi.util;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrimmedConfig {
    @Bean
    public BeanPostProcessor trimmedBeanPostProcessor() {
        return new TrimmedAnnotationBeanPostProcessor();
    }
}
