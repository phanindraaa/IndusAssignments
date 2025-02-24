package com.indus.training.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class EmplConfig {

    @Bean
    public Calculator calculator() {
        return new CalcImpl();
    }
}