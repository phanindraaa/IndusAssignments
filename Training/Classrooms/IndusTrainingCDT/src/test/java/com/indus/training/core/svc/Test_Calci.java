package com.indus.training.core.svc;

import junit.framework.TestCase;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOutput;
import com.indus.training.core.impl.ICalci;

public class Test_Calci extends TestCase {
	private ICalci calculator;
	
	protected void setUp() throws Exception {
		calculator = new ICalci();
	}
	
	protected void tearDown() throws Exception {
		calculator = null;
	}
	
	public void testAdditionScenario1() {
		
		// 1) Input
		CalcInput CalInObj = new CalcInput();
		CalInObj.param1 = 10.0;
		CalInObj.param2 = 20.0;
		
		//2) expected output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 10.0;
		expCalOutObj.param2 = 20.0;
		expCalOutObj.result = 30.0;
		expCalOutObj.operation ="Add";
		
		//3) actual output
		CalcOutput actCalOutObj = calculator.add(CalInObj);
		
		
		// 4) assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}
	
	public void testAdditionScenario2() {
		
		// 1) Input
		CalcInput CalInObj = new CalcInput();
		CalInObj.param1 = 0.0;
		CalInObj.param2 = 1000.0;
		
		//2) expected output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 0.0;
		expCalOutObj.param2 = 1000.0;
		expCalOutObj.result = 1000.0;
		expCalOutObj.operation ="Add";
		
		//3) actual output
		CalcOutput actCalOutObj = calculator.add(CalInObj);
		
		
		// 4) assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}
	
	public void testAdditionScenario3() {
		
		// 1) Input
		CalcInput CalInObj = new CalcInput();
		CalInObj.param1 = -100.0;
		CalInObj.param2 = 50.0;
		
		//2) expected output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = -100.0;
		expCalOutObj.param2 = 50.0;
		expCalOutObj.result = -50.0;
		expCalOutObj.operation ="Add";
		
		//3) actual output
		CalcOutput actCalOutObj = calculator.add(CalInObj);
		
		
		// 4) assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}
	
	public void testSubtractionScenario1() {
		
		//1) Input
		CalcInput CalInObj = new CalcInput();
		CalInObj.param1 = 10.0;
		CalInObj.param2 = 3.0;
		
		//2) expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 10.0;
		expCalOutObj.param2 = 3.0;
		expCalOutObj.result = 7.0;
		expCalOutObj.operation = "Sub";
		
		//3) Actual Output
		CalcOutput actCatOutObj = calculator.sub(CalInObj);
		
		//4) assertion
		assertEquals(expCalOutObj.param1, actCatOutObj.param1);
		assertEquals(expCalOutObj.param2, actCatOutObj.param2);
		assertEquals(expCalOutObj.result, actCatOutObj.result);
		
	}
	
	public void testSubtractionScenario2() {
		
		//1) Input
		CalcInput CalInObj = new CalcInput();
		CalInObj.param1 = -10.0;
		CalInObj.param2 = 3.0;
		
		//2) expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = -10.0;
		expCalOutObj.param2 = 3.0;
		expCalOutObj.result = -13.0;
		expCalOutObj.operation = "Sub";
		
		//3) Actual Output
		CalcOutput actCatOutObj = calculator.sub(CalInObj);
		
		//4) assertion
		assertEquals(expCalOutObj.param1, actCatOutObj.param1);
		assertEquals(expCalOutObj.param2, actCatOutObj.param2);
		assertEquals(expCalOutObj.result, actCatOutObj.result);
		
	}
	
	public void testSubtractionScenario3() {
		
		//1) Input
		CalcInput CalInObj = new CalcInput();
		CalInObj.param1 = 0.0;
		CalInObj.param2 = -3.0;
		
		//2) expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 0.0;
		expCalOutObj.param2 = -3.0;
		expCalOutObj.result = 3.0;
		expCalOutObj.operation = "Sub";
		
		//3) Actual Output
		CalcOutput actCatOutObj = calculator.sub(CalInObj);
		
		//4) assertion
		assertEquals(expCalOutObj.param1, actCatOutObj.param1);
		assertEquals(expCalOutObj.param2, actCatOutObj.param2);
		assertEquals(expCalOutObj.result, actCatOutObj.result);
		
	}

	public void testMultiplicationScenario1() {
		
		//1) Input
		CalcInput calInputObj = new CalcInput();
		calInputObj.param1 = 10.0;
		calInputObj.param2 = 2.0;
		
		//2) Expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 10.0;
		expCalOutObj.param2 = 2.0;
		expCalOutObj.result = 20.0;
		expCalOutObj.operation = "Mul";
		
		//3) Actual Output
		CalcOutput actCalOutObj = calculator.mul(calInputObj);
		
		//4) Assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}
	
	public void testMultiplicationScenario2() {
		
		//1) Input
		CalcInput calInputObj = new CalcInput();
		calInputObj.param1 = 0.0;
		calInputObj.param2 = 5.0;
		
		//2) Expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 0.0;
		expCalOutObj.param2 = 5.0;
		expCalOutObj.result = 0.0;
		expCalOutObj.operation = "Mul";
		
		//3) Actual Output
		CalcOutput actCalOutObj = calculator.mul(calInputObj);
		
		//4) Assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}
	
	public void testMultiplicationScenario3() {
		
		//1) Input
		CalcInput calInputObj = new CalcInput();
		calInputObj.param1 = 100.0;
		calInputObj.param2 = 1000.0;
		
		//2) Expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 100.0;
		expCalOutObj.param2 = 1000.0;
		expCalOutObj.result = 100000.0;
		expCalOutObj.operation = "Mul";
		
		//3) Actual Output
		CalcOutput actCalOutObj = calculator.mul(calInputObj);
		
		//4) Assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}

	public void testDivisionScenario1() {
		
		//1) Input
		CalcInput calInputObj = new CalcInput();
		calInputObj.param1 = 10.0;
		calInputObj.param2 = 2.0;
		
		//2) Expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 10.0;
		expCalOutObj.param2 = 2.0;
		expCalOutObj.result = 5.0;
		expCalOutObj.operation = "Div";
		
		//3) Actual Output
		CalcOutput actCalOutObj = calculator.div(calInputObj);
		
		//4) Assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}
	
	public void testDivisionScenario2() {
		
		//1) Input
		CalcInput calInputObj = new CalcInput();
		calInputObj.param1 = 0.0;
		calInputObj.param2 = 2.0;
		
		//2) Expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 0.0;
		expCalOutObj.param2 = 2.0;
		expCalOutObj.result = 0.0;
		expCalOutObj.operation = "Div";
		
		//3) Actual Output
		CalcOutput actCalOutObj = calculator.div(calInputObj);
		
		//4) Assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}
	
	public void testDivisionScenario3() {
		
		//1) Input
		CalcInput calInputObj = new CalcInput();
		calInputObj.param1 = 10000.0;
		calInputObj.param2 = 1.0;
		
		//2) Expected Output
		CalcOutput expCalOutObj = new CalcOutput();
		expCalOutObj.param1 = 10000.0;
		expCalOutObj.param2 = 1.0;
		expCalOutObj.result = 10000.0;
		expCalOutObj.operation = "Div";
		
		//3) Actual Output
		CalcOutput actCalOutObj = calculator.div(calInputObj);
		
		//4) Assertion
		assertEquals(expCalOutObj.param1, actCalOutObj.param1);
		assertEquals(expCalOutObj.param2, actCalOutObj.param2);
		assertEquals(expCalOutObj.result, actCalOutObj.result);
		assertEquals(expCalOutObj.operation, actCalOutObj.operation);
	}

}
