package com.indus.project.service;

import com.indus.project.entity.Portfolio;
import com.indus.project.model.PortfolioEvent;
import com.indus.project.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private PortfolioEventProducer eventProducer; // RabbitMQ Producer

    /**
     * Get all portfolios
     */
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    /**
     * Get portfolios by user ID
     */
    public List<Portfolio> getPortfoliosByUserId(Long userId) {
        return portfolioRepository.findAll().stream()
                .filter(portfolio -> portfolio.getUser().getUserId().equals(userId))
                .toList();
    }

    /**
     * Add a new portfolio and send an event to RabbitMQ
     */
    public Portfolio addPortfolio(Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);

        // Publish event to RabbitMQ
        PortfolioEvent event = new PortfolioEvent(savedPortfolio.getPortfolioId(), "CREATE", "Portfolio Created");
        eventProducer.sendPortfolioEvent(event);

        return savedPortfolio;
    }

    /**
     * Delete a portfolio by ID and send an event to RabbitMQ
     */
    public void deletePortfolio(Long portfolioId) {
        portfolioRepository.deleteById(portfolioId);

        // Publish event to RabbitMQ
        PortfolioEvent event = new PortfolioEvent(portfolioId, "DELETE", "Portfolio Deleted");
        eventProducer.sendPortfolioEvent(event);
    }
}
