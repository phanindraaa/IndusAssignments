package com.indus.training.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
  //creating a bean  
    @Bean  
    //creating a sampler called   
    public Sampler defaultSampler()  
    {  
    return Sampler.ALWAYS_SAMPLE;  
    }  
    }  
}
