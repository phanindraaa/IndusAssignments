package com.indus.project.service;

import com.indus.project.model.PortfolioEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class PortfolioEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public PortfolioEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendPortfolioEvent(PortfolioEvent event) {
        rabbitTemplate.convertAndSend("portfolio.exchange", "portfolio.routingKey", event);
        System.out.println("Portfolio Event Sent: " + event);
    }
}
