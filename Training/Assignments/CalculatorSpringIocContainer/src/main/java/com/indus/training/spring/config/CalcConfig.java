package com.indus.training.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.indus.training.spring.impl.CalcImpl;
import com.indus.training.spring.svc.Calculator;

@Configuration
public class CalcConfig {

    @Bean
    @Scope
    
    public Calculator calculator() {
        return new CalcImpl();
    }
}