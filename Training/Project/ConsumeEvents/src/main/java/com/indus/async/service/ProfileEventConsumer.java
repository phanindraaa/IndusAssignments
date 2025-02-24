package com.indus.async.service;

import com.indus.async.config.RabbitMQConfig;
import com.indus.async.model.PortfolioEvent;
import com.indus.async.repository.PortfolioEventRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ProfileEventConsumer {

    private final PortfolioEventRepository repository;

    // Constructor-based dependency injection for the repository
    public ProfileEventConsumer(PortfolioEventRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handlePortfolioEvent(PortfolioEvent event) {
        System.out.println("Received Portfolio Event: " + event);

        // Save the event to MongoDB
        saveEventToDatabase(event);
    }

    private void saveEventToDatabase(PortfolioEvent event) {
        try {
            repository.save(event);
            System.out.println("Saved to MongoDB: " + event);
        } catch (Exception e) {
            System.err.println("Failed to save event to MongoDB: " + e.getMessage());
        }
    }
}
