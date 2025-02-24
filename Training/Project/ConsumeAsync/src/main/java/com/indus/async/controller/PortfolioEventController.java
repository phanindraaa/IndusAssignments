package com.indus.async.controller;

import com.indus.async.model.PortfolioEvent;
import com.indus.async.service.PortfolioEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class PortfolioEventController {

    @Autowired
    private PortfolioEventService portfolioEventService;

    /**
     * Get all portfolio events stored in MongoDB.
     */
    @GetMapping
    public List<PortfolioEvent> getAllPortfolioEvents() {
        return portfolioEventService.getAllEvents();
    }

    /**
     * Get a specific portfolio event by its MongoDB ID.
     */
    @GetMapping("/{id}")
    public PortfolioEvent getPortfolioEventById(@PathVariable String id) {
        return portfolioEventService.getEventById(id);
    }

    /**
     * Delete all portfolio events from MongoDB (for cleanup).
     */
    @DeleteMapping
    public String deleteAllPortfolioEvents() {
        portfolioEventService.deleteAllEvents();
        return "All portfolio events deleted successfully!";
    }
}
