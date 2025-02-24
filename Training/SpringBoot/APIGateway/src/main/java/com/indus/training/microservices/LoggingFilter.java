package com.indus.training.microservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class LoggingFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Bean
    public GlobalFilter logFilter() {
        return (exchange, chain) -> {
            ServerWebExchange request = exchange;
            logger.info("Request Path -> {}", request.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("Response Code -> {}", exchange.getResponse().getStatusCode());
            }));
        };
    }
}
