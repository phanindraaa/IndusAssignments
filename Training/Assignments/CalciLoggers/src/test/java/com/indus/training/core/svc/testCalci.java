package com.indus.training.core.svc;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOutput;
import com.indus.training.core.exception.CalculationException;
import com.indus.training.core.exception.DivisionByZeroException;
import com.indus.training.core.impl.Calci;

import junit.framework.TestCase;

public class testCalci extends TestCase {
	
	private Calci calculator;

	protected void setUp() throws Exception {
		super.setUp();
		calculator = new Calci();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAdditionInvalidInput() {
	    CalcInput calInput = null; 

	    try {
	        calculator.Addition(calInput);
	        fail("CalculationException");
	    } catch (CalculationException e) {
//	    	e.printStackTrace();
	    }
	}

	public void testAdditionValidInput() {
	    CalcInput calInput = new CalcInput();
	    calInput.setParam1(5);
	    calInput.setParam2(3);

	    try {
	        CalcOutput calOutput = calculator.Addition(calInput);
	        assertNotNull(calOutput);
	        assertEquals(Double.valueOf(8.0), calOutput.getResult());
	    } catch (CalculationException e) {
	        fail("No Exception");
	    }
	}

	public void testDivisionByZero() {
	    CalcInput calInput = new CalcInput();
	    calInput.setParam1(5);
	    calInput.setParam2(0);

	    try {
	        calculator.Division(calInput);
	        fail("Divisionbyzero exception");
	    } catch (DivisionByZeroException e) {
	    } catch (CalculationException e) {
	        fail("Unexpected calcexception");
	    }
	}

	public void testMultiplicationValidInput() {
	    CalcInput calInput = new CalcInput();
	    calInput.setParam1(5);
	    calInput.setParam2(3);

	    try {
	        CalcOutput calOutput = calculator.Multiply(calInput);
	        assertNotNull(calOutput);
	        assertEquals(Double.valueOf(15.0), calOutput.getResult());
	    } catch (CalculationException e) {
	        fail("no exception");
	    }
	}
}
