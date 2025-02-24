package com.indus.training.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.indus.training.spring.controller", 
    "com.indus.training.spring.dao",
    "com.indus.training.spring.config"
})
@EnableJpaRepositories(basePackages = "com.indus.training.spring.dao")
@Import(JpaConfig.class)
public class AppConfig {
}