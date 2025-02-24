package com.indus.project.controller;

import com.indus.project.entity.Portfolio;
import com.indus.project.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolios")
@CrossOrigin(origins = "*")

public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // Get all portfolios
    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    // Get portfolios by user ID
    @GetMapping("/user/{userId}")
    public List<Portfolio> getPortfoliosByUserId(@PathVariable Long userId) {
        return portfolioService.getPortfoliosByUserId(userId);
    }

    // Add a new portfolio
    @PostMapping
    public Portfolio addPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.addPortfolio(portfolio);
    }

    // Delete a portfolio by ID
    @DeleteMapping("/{portfolioId}")
    public String deletePortfolio(@PathVariable Long portfolioId) {
        portfolioService.deletePortfolio(portfolioId);
        return "Portfolio deleted successfully!";
    }
}
