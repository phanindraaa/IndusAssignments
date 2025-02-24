package com.indus.training.core.svc;

import junit.framework.TestCase;
import com.indus.training.core.impl.Flight;

public class testTravel extends TestCase {
    
    private Flight flight;

    protected void setUp() throws Exception {
        super.setUp();
        flight = new Flight();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        flight = null;
    }

    public void testFlightDetailsScenario() {
        // 1) Input
        String destination = "Paris";
        double duration = 8.0;

        // 2) Expected Output
        String expOutput = "Flight Destination: " + destination + ", Duration: " + duration + " hours";

        // 3) Actual Output
        String actOutput = flight.getDetails(destination, duration);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }

    public void testFlightBookScenario() {
        // Expected Output
        String expOutput = "Booking flight";

        // Actual Output
        String actOutput = flight.book();

        // Assertions
        assertEquals(expOutput, actOutput);
    }
}
