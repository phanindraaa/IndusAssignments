package com.indus.project;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSetupRunner implements CommandLineRunner {

    private final RabbitAdmin rabbitAdmin;

    public RabbitMQSetupRunner(RabbitAdmin rabbitAdmin) {
        this.rabbitAdmin = rabbitAdmin;
    }

    @Override
    public void run(String... args) {
        System.out.println("Declaring RabbitMQ components manually...");
        rabbitAdmin.declareQueue(new Queue("portfolio.queue", true));
        rabbitAdmin.declareExchange(new TopicExchange("portfolio.exchange"));
        System.out.println("Components declared successfully.");
    }
}
