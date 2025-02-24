package com.indus.project;

import com.indus.async.model.PortfolioEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQTestPublisher implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQTestPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        System.out.println("Publishing test message to RabbitMQ...");

        // Send a properly structured PortfolioEvent
        PortfolioEvent event = new PortfolioEvent();
        event.setPortfolioId(1L);
        event.setAction("CREATE");
        event.setDetails("Portfolio Created");

        rabbitTemplate.convertAndSend("portfolio.exchange", "portfolio.routingKey", event);

        System.out.println("Test message sent successfully.");
    }
}
