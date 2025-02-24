package com.spring.training;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<HelloServelet> helloServletBean() {
        ServletRegistrationBean<HelloServelet> bean = new ServletRegistrationBean<>(
            new HelloServelet(), "/hello");
        bean.setLoadOnStartup(1);
        return bean;
    }
}