package com.indus.training.core.svc;

import com.indus.training.core.impl.SubjectManagerImpl;

import junit.framework.TestCase;

public class testSubjectManager extends TestCase {
	
	    private SubjectManagerImpl manager;

	    protected void setUp() throws Exception {
	        super.setUp();
	        manager = new SubjectManagerImpl();
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	        manager = null;
	    }

	    public void testAddSubject() {
	        // 1. Input
	        manager.addSubject("Mathematics");

	        // 2. Expected output
	        String expectedOutput = "Mathematics\n";

	        // 3. Actual output
	        String actualOutput = manager.listSubjects();

	        // 4. Assertions
	        assertEquals(expectedOutput, actualOutput);
	    }

	    public void testListSubjects() {
	        // Setup initial state
	        manager.addSubject("Mathematics");
	        manager.addSubject("Science");

	        // 1. Input
	        // No input required for this test

	        // 2. Expected output
	        String expectedOutput = "Mathematics\nScience\n";

	        // 3. Actual output
	        String actualOutput = manager.listSubjects();

	        // 4. Assertions
	        assertEquals(expectedOutput, actualOutput);
	    }

	    public void testListSubjectsEmpty() {
	        // 1. Input
	        // No subjects added

	        // 2. Expected output
	        String expectedOutput = "No subjects available";

	        // 3. Actual output
	        String actualOutput = manager.listSubjects();

	        // 4. Assertions
	        assertEquals(expectedOutput, actualOutput);
	    }

}
