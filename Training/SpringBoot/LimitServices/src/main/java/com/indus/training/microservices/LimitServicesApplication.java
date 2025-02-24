package com.indus.training.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class LimitServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitServicesApplication.class, args);
	}

}
