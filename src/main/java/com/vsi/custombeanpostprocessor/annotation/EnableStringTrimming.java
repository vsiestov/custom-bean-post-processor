package com.vsi.custombeanpostprocessor.annotation;

import com.vsi.util.TrimmedConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Import(TrimmedConfig.class)
public @interface EnableStringTrimming {
}
