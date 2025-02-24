package com.indus.async.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Ensures a default constructor exists
@Document(collection = "PortfolioEvent") // Maps this class to a MongoDB collection
public class PortfolioEvent {
    @Id
    private String id; // MongoDB document ID

    private Long portfolioId;
    private String action; // CREATE, DELETE
    private String details;

    // Getters and setters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
