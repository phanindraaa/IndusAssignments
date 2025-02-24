package com.indus.project.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PortfolioEvent implements Serializable {

    private Long portfolioId;
    private String action; // e.g., CREATE, DELETE
    private String details;

    public PortfolioEvent(Long portfolioId, String action, String details) {
        this.portfolioId = portfolioId;
        this.action = action;
        this.details = details;
    }

    public PortfolioEvent() {
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
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
