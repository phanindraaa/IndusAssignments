package com.indus.training.core.impl;

import com.indus.training.core.svc.BaseInterestCalculator;

// Class for simple interest calculation.
public class SimpleInterestCalculator extends BaseInterestCalculator {

    // Calculates the interest based on the principal amount, rate, and time.
    public double calculateInterest(double principal, double rate, int time) {
        interest = principal * rate * time;
        return interest;
    }

    // Gets the interest type.
    public String getInterestType() {
        return "Simple Interest";
    }
}
