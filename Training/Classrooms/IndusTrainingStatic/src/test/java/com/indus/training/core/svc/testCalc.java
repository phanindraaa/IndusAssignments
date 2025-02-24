package com.indus.training.core.svc;
import com.indus.training.core.svc.CalcInterface;
import com.indus.training.core.impl.Calc;
import com.indus.training.core.domain.CalcInput;
import junit.framework.TestCase;

public class testCalc extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	//1) input
	public void testSubtract() {
		CalcInput.param1 = 20;
		CalcInput.param2 = 10;
		double expResult = 10;
		double actResult = Calc.Subtract();
		assertEquals(expResult, actResult);
	}
	
	public void testAddition() {
		CalcInput.param1 = 20;
		CalcInput.param2 = 20;
		double expResult = 40;
		double actResult = CalcInterface.Addition();
		assertEquals(expResult, actResult);
	}
}
