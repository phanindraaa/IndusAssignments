package com.indus.training.spring.config;

public class CalculatorResponse {
    private double result;

    public CalculatorResponse(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
