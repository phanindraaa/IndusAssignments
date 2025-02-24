package com.indus.training.core.svc;

// Interface for interest calculation.
public interface InterestCalculator {
    // Calculates the interest based on the principal amount and rate.
    double calculateInterest(double principal, double rate);

    // Gets the interest type.
    String getInterestType();
}
