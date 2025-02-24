package com.indus.training.core.svc;

import com.indus.training.core.impl.Day;

import junit.framework.TestCase;

public class testDay extends TestCase {

//	protected void setUp1() throws Exception {
//		super.setUp1();
//	}
//
//	protected void tearDown() throws Exception {
//		super.tearDown();
//	}
//	
//	 // Setup method to run before each test
//    @Before
//    public void setUp() throws Exception {
//        // Any setup can be done here if necessary
//    }
//
//    // Teardown method to run after each test
//    @After
//    public void tearDown() throws Exception {
//        // Any cleanup can be done here if necessary
//    }

    public void testMonday() {
        // Input
        Day monday = Day.MONDAY;
        
        // Expected Output
        String expectedOutput = "Monday";
        
        // Actual Output
        String actualOutput = monday.getDayName();
        
        // Assertions
        assertEquals(expectedOutput, actualOutput);
    }

    public void testFriday() {
        // Input
        Day friday = Day.FRIDAY;
        
        // Expected Output
        String expectedOutput = "Friday";
        
        // Actual Output
        String actualOutput = friday.getDayName();
        
        // Assertions
        assertEquals(expectedOutput, actualOutput);
    }

    // Additional test cases can be added similarly for other days

}
