package com.indus.training.core.svc;

import junit.framework.TestCase;
import com.indus.training.core.impl.Bus;
import com.indus.training.core.impl.Train;

public class testTransportOverride extends TestCase {
    
    private Transport bus;
    private Transport train;

    protected void setUp() throws Exception {
        bus = new Bus();
        train = new Train();
    }

    protected void tearDown() throws Exception {
        bus = null;
        train = null;
    }

    public void testBusDetailsScenario() {
        // 1) Input
        String model = "Volvo";
        int capacity = 50;

        // 2) Expected Output
        String expOutput = "Bus -> Model: " + model + ", Capacity: " + capacity;

        // 3) Actual Output
        String actOutput = bus.getDetails(model, capacity);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }

    public void testTrainDetailsScenario() {
        // 1) Input
        String model = "Bullet Train";
        int capacity = 200;

        // 2) Expected Output
        String expOutput = "Train -> Model: " + model + ", Capacity: " + capacity;

        // 3) Actual Output
        String actOutput = train.getDetails(model, capacity);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }
}
