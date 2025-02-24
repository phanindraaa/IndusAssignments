package com.indus.training.core.svc;

import com.indus.training.core.impl.Month;

import junit.framework.TestCase;

public class testMonth extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testJanuary() {
        // Input
        Month january = Month.JANUARY;
        
        // Expected Output
        String expectedName = "January";
        int expectedDays = 31;
        
        // Actual Output
        String actualName = january.getMonthName();
        int actualDays = january.getDays();
        
        // Assertions
        assertEquals(expectedName, actualName);
        assertEquals(expectedDays, actualDays);
    }

    public void testFebruary() {
        // Input
        Month february = Month.FEBRUARY;
        
        // Expected Output
        String expectedName = "February";
        int expectedDays = 28;
        
        // Actual Output
        String actualName = february.getMonthName();
        int actualDays = february.getDays();
        
        // Assertions
        assertEquals(expectedName, actualName);
        assertEquals(expectedDays, actualDays);
    }

}
