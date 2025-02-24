package com.indus.async.service;

import com.indus.async.model.PortfolioEvent;
import com.indus.async.repository.PortfolioEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioEventService {

    private final PortfolioEventRepository repository;

    public PortfolioEventService(PortfolioEventRepository repository) {
        this.repository = repository;
    }

    public List<PortfolioEvent> getAllEvents() {
        return repository.findAll();
    }
}
