package com.indus.training.core.svc;

import com.indus.training.core.impl.Planet;

import junit.framework.TestCase;

public class testPlanet extends TestCase {


    public void setUp() throws Exception {
    	super.setUp();
    }

    public void tearDown() throws Exception {
    	super.tearDown();
    }

    public void testEarth() {
        // Input
        Planet earth = Planet.EARTH;
        
        // Expected Output
        String expectedName = "Earth";
        double expectedRank = 3;    
        // Actual Output
        String actualName = earth.getPlanetName();
        double actualDistance = earth.getRanking();
        
        // Assertions
        assertEquals(expectedName, actualName);
        assertEquals(expectedRank, actualDistance, 3);
    }

    public void testMars() {
        // Input
        Planet mars = Planet.MARS;
        
        // Expected Output
        String expectedName = "Mars";
        double expectedRank = 4;
        
        // Actual Output
        String actualName = mars.getPlanetName();
        double actualDistance = mars.getRanking();
        
        // Assertions
        assertEquals(expectedName, actualName);
        assertEquals(expectedRank, actualDistance, 4);
    }

}
