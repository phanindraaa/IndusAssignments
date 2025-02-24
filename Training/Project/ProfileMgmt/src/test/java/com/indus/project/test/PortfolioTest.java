package com.indus.project.test;

import com.indus.project.entity.Portfolio;
import com.indus.project.entity.User;
import com.indus.project.model.PortfolioEvent;
import com.indus.project.repository.PortfolioRepository;
import com.indus.project.service.PortfolioEventProducer;
import com.indus.project.service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PortfolioTest {

    @Mock
    private PortfolioRepository portfolioRepository;

    @Mock
    private PortfolioEventProducer eventProducer; // Mock PortfolioEventProducer

    @InjectMocks
    private PortfolioService portfolioService;

    private Portfolio portfolio;
    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setUserId(1L);
        user.setUsername("john_doe");

        portfolio = new Portfolio();
        portfolio.setPortfolioId(1L);
        portfolio.setStockSymbol("AAPL");
        portfolio.setShares(100);
        portfolio.setUser(user);
    }

    @Test
    public void testAddPortfolio() {
        when(portfolioRepository.save(portfolio)).thenReturn(portfolio);

        Portfolio savedPortfolio = portfolioService.addPortfolio(portfolio);
        assertEquals("AAPL", savedPortfolio.getStockSymbol());

        verify(portfolioRepository, times(1)).save(portfolio);
        verify(eventProducer, times(1)).sendPortfolioEvent(any(PortfolioEvent.class)); // Verify event
    }

    @Test
    public void testDeletePortfolio() {
        doNothing().when(portfolioRepository).deleteById(1L);

        portfolioService.deletePortfolio(1L);

        verify(portfolioRepository, times(1)).deleteById(1L);
        verify(eventProducer, times(1)).sendPortfolioEvent(any(PortfolioEvent.class)); // Verify event
    }
}
