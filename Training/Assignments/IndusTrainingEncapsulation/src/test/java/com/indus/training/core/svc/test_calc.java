package com.indus.training.core.svc;

import com.indus.training.core.impl.calc;

import junit.framework.TestCase;

public class test_calc extends TestCase {
	
	private calc calculator;

	protected void setUp() throws Exception {
		calculator = new calc();
	}

	protected void tearDown() throws Exception {
		calculator = null;
	}
	
	public void testAdditionScenario1() {
		double result = 0;
		result = calculator.addition(5.0, 2.0);
		assertEquals(result, 7.0);
		
	}
	
	public void testAdditionScenario2() {
		double result = 0;
		result = calculator.addition(5.0, 2.0);
		assertEquals(result, 7.0);
		
	}
	
	public void testSubtraction() {
		double result = 0;
		result = calculator.subtract(10.0, 5.0);
		assertEquals(result, 5.0);
		
	}
	
	public void testMultiplication() {
		double result = 0;
		result = calculator.multiply(5.0, 2.0);
		assertEquals(result, 10.0);
		
	}
	
	public void test_addition() {
		double result = 0;
		result = calculator.division(10.0, 2.0);
		assertEquals(result, 5.0);
		
	}

}
