package com.indus.training.core.svc;

import com.indus.training.core.impl.SimpleInterestCalculator;

import junit.framework.TestCase;

// Test case for SimpleInterestCalculator.
public class TestSimpleCalc extends TestCase {

    // Tests the interest calculation.
    public void testCalculateInterest() {
        // input
        SimpleInterestCalculator calculator = new SimpleInterestCalculator();
        double principal = 1000;
        double rate = 0.05;
        int time = 2;

        // expected output
        double expectedInterest = 100.0;

        // actual output
        double actualInterest = calculator.calculateInterest(principal, rate, time);

        // assertions
        assertEquals(expectedInterest, actualInterest, 0.001);
    }

    // Tests the interest type.
    public void testGetInterestType() {
        // input
        SimpleInterestCalculator calculator = new SimpleInterestCalculator();

        // expected output
        String expectedType = "Simple Interest";

        // actual output
        String actualType = calculator.getInterestType();

        // assertions
        assertEquals(expectedType, actualType);
    }
}
