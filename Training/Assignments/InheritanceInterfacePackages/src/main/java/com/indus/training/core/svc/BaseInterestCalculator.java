package com.indus.training.core.svc;

// Base class for interest calculation.
public class BaseInterestCalculator implements InterestCalculator {
    protected double interest;

    // Calculates the interest based on the principal amount and rate.
    public double calculateInterest(double principal, double rate) {
        interest = principal * rate;
        return interest;
    }

    // Gets the interest type.
    public String getInterestType() {
        return "Base Interest";
    }
}
