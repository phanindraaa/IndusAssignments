package com.indus.training.core.svc;

import junit.framework.TestCase;
import com.indus.training.core.impl.Trip;

public class testTrip extends TestCase {
    
    private Trip trip;

    protected void setUp() throws Exception {
        super.setUp();
        trip = new Trip();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        trip = null;
    }

    public void testTripDetailsWithDestination() {
        // 1) Input
        String destination = "Paris";

        // 2) Expected Output
        String expOutput = "Trip to " + destination;

        // 3) Actual Output
        String actOutput = trip.getDetails(destination);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }

    public void testTripDetailsWithDestinationAndDuration() {
        // 1) Input
        String destination = "Paris";
        double duration = 5.0;

        // 2) Expected Output
        String expOutput = "Trip to " + destination + " for " + duration + " days";

        // 3) Actual Output
        String actOutput = trip.getDetails(destination, duration);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }

    public void testTripDetailsWithAllParameters() {
        // 1) Input
        String destination = "Paris";
        double duration = 5.0;
        String travelMode = "flight";

        // 2) Expected Output
        String expOutput = "Trip to " + destination + " for " + duration + " days by " + travelMode;

        // 3) Actual Output
        String actOutput = trip.getDetails(destination, duration, travelMode);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }
}
