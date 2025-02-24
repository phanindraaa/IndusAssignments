package com.indus.project.service;

import com.indus.project.entity.Portfolio;
import com.indus.project.entity.Transaction;
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

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public List<Portfolio> getPortfoliosByUserId(Long userId) {
        return portfolioRepository.findAll().stream()
                .filter(portfolio -> portfolio.getUser().getUserId().equals(userId))
                .toList();
    }

    public Portfolio addPortfolio(Portfolio portfolio) {
        Portfolio savedPortfolio = portfolioRepository.save(portfolio);
        PortfolioEvent event = new PortfolioEvent(savedPortfolio.getPortfolioId(), "CREATE", "Portfolio Created");
        eventProducer.sendPortfolioEvent(event);
        return savedPortfolio;
    }

    public void deletePortfolio(Long portfolioId) {
        portfolioRepository.deleteById(portfolioId);
        PortfolioEvent event = new PortfolioEvent(portfolioId, "DELETE", "Portfolio Deleted");
        eventProducer.sendPortfolioEvent(event);
    }

    public void updateShares(Long portfolioId, Transaction transaction) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        if ("BUY".equalsIgnoreCase(transaction.getTransactionType())) {
            portfolio.setShares(portfolio.getShares() + transaction.getQuantity());
        } else if ("SELL".equalsIgnoreCase(transaction.getTransactionType())) {
            if (portfolio.getShares() >= transaction.getQuantity()) {
                portfolio.setShares(portfolio.getShares() - transaction.getQuantity());
            } else {
                throw new RuntimeException("Not enough shares to sell");
            }
        }

        portfolioRepository.save(portfolio);
    }
}