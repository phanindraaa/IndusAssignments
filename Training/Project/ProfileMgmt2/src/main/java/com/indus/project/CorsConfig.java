package com.indus.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Match all endpoints
                .allowedOrigins("http://localhost:3000") // Only allow the React frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow HTTP methods
                .allowedHeaders("Authorization", "Content-Type", "X-Requested-With") // Allow required headers
                .exposedHeaders("Authorization") // Allow frontend to access the Authorization header
                .allowCredentials(true); // Allow cookies and Authorization headers
    }
}
