package com.indus.training.core.svc;

import com.indus.training.core.impl.SimpleInterestCalculator;
import junit.framework.TestCase;

// Test case for SimpleInterestCalculator.
public class TestSimpleCalc extends TestCase {
    private SimpleInterestCalculator calculator;

    protected void setUp() throws Exception {
        super.setUp();
        calculator = new SimpleInterestCalculator();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        calculator = null;
    }

    public void testCalculateInterest() {
        // 1. Input
        double principal = 1000.0;
        double rate = 0.05;
        int time = 2;

        // 2. Expected output
        double expectedInterest = 100.0;

        // 3. Actual output
        double actualInterest = calculator.calculateInterest(principal, rate, time);

        // 4. Assertions
        assertEquals(expectedInterest, actualInterest, 0.001);
    }

    public void testGetInterestType() {
        // 1. Input

        // 2. Expected output
        String expectedType = "Simple Interest";

        // 3. Actual output
        String actualType = calculator.getInterestType();

        // 4. Assertions
        assertEquals(expectedType, actualType);
    }
}
