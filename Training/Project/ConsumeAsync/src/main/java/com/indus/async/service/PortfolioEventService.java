package com.indus.async.service;

import com.indus.async.model.PortfolioEvent;
import com.indus.async.repository.PortfolioEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioEventService {

    private final PortfolioEventRepository repository;

    public PortfolioEventService(PortfolioEventRepository repository) {
        this.repository = repository;
    }

    public List<PortfolioEvent> getAllEvents() {
        return repository.findAll();
    }

    public PortfolioEvent getEventById(String id) {
        Optional<PortfolioEvent> event = repository.findById(id);
        return event.orElseThrow(() -> new RuntimeException("PortfolioEvent not found with id: " + id));
    }

    public void deleteAllEvents() {
        repository.deleteAll();
    }
}
