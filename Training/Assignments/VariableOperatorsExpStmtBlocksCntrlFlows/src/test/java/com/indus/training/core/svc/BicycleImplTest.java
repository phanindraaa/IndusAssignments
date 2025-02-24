package com.indus.training.core.svc;

import com.indus.training.core.impl.BicycleImpl;

import junit.framework.TestCase;

public class BicycleImplTest extends TestCase {
    private BicycleImpl bicycle;

    // Called before each test method
    protected void setUp() throws Exception {
        super.setUp();
        bicycle = new BicycleImpl();
    }

    // Called after each test method
    protected void tearDown() throws Exception {
        super.tearDown();
        bicycle = null;
    }

    public void testSetGear() {
        // 1. Input
        int gear = 3;

        // 2. Expected output
        String expectedState = "Speed: 0, Gear: 3";

        // 3. Actual output
        bicycle.setGear(gear);
        String actualState = bicycle.getCurrentState();

        // 4. Assertions
        assertEquals(expectedState, actualState);
    }

    public void testApplyBrakes() {
        // 1. Input
        bicycle.speedUp(20);
        int brakeForce = 5;

        // 2. Expected output
        String expectedState = "Speed: 15, Gear: 1";

        // 3. Actual output
        bicycle.applyBrakes(brakeForce);
        String actualState = bicycle.getCurrentState();

        // 4. Assertions
        assertEquals(expectedState, actualState);
    }

    public void testSpeedUp() {
        // 1. Input
        int increment = 10;

        // 2. Expected output
        String expectedState = "Speed: 10, Gear: 1";

        // 3. Actual output
        bicycle.speedUp(increment);
        String actualState = bicycle.getCurrentState();

        // 4. Assertions
        assertEquals(expectedState, actualState);
    }

    public void testReset() {
        // 1. Input
        bicycle.speedUp(10);
        bicycle.setGear(5);

        // 2. Expected output
        String expectedState = "Speed: 0, Gear: 1";

        // 3. Actual output
        bicycle.reset();
        String actualState = bicycle.getCurrentState();

        // 4. Assertions
        assertEquals(expectedState, actualState);
    }

    public void testGradualBrakes() {
        // 1. Input
        bicycle.speedUp(10);

        // 2. Expected output
        String expectedState = "Speed: 0, Gear: 1";

        // 3. Actual output
        bicycle.gradualBrakes();
        String actualState = bicycle.getCurrentState();

        // 4. Assertions
        assertEquals(expectedState, actualState);
    }

    public void testPedalToSpeed() {
        // 1. Input
        int pedalSpeed = 5;

        // 2. Expected output
        String expectedState = "Speed: 5, Gear: 1";

        // 3. Actual output
        bicycle.pedalToSpeed(pedalSpeed);
        String actualState = bicycle.getCurrentState();

        // 4. Assertions
        assertEquals(expectedState, actualState);
    }
}
