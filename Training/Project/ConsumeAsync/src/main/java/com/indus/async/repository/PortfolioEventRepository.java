package com.indus.async.repository;

import com.indus.async.model.PortfolioEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioEventRepository extends MongoRepository<PortfolioEvent, String> {
}
