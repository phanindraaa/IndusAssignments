package com.indus.training.core.svc;

import com.indus.training.core.domain.NumAvgInp;
import com.indus.training.core.domain.NumAvgOut;
import com.indus.training.core.impl.NumAvg;

import junit.framework.TestCase;

public class test_NumAvg extends TestCase {

	private NumAvg NumAvgObj;

	protected void setUp() throws Exception {
		NumAvgObj = new NumAvg();
	}

	protected void tearDown() throws Exception {
		NumAvgObj = null;
	}
	
	public void testNumAvgScenario1() {
		
		//1) Input
		NumAvgInp NumAvgInpObj = new NumAvgInp();
		NumAvgInpObj.num1 = 3;
		NumAvgInpObj.num2 = 6;
		NumAvgInpObj.num3 = 9;
		NumAvgInpObj.num4 = 12;
		NumAvgInpObj.num5 = 15;
		
		//2) Expected Output
		NumAvgOut expNumAvgOutObj = new NumAvgOut();
		expNumAvgOutObj.num1 = 3;
		expNumAvgOutObj.num2 = 6;
		expNumAvgOutObj.num3 = 9;
		expNumAvgOutObj.num4 = 12;
		expNumAvgOutObj.num5 = 15;
		expNumAvgOutObj.Average = 9;
		
		//3) Actual Output
		NumAvgOut actNumAvgOutObj = NumAvgObj.NumberAvg(NumAvgInpObj);
		
		//4) Assertions
		assertEquals(expNumAvgOutObj.num1, actNumAvgOutObj.num1);
		assertEquals(expNumAvgOutObj.num2, actNumAvgOutObj.num2);
		assertEquals(expNumAvgOutObj.num3, actNumAvgOutObj.num3);
		assertEquals(expNumAvgOutObj.num4, actNumAvgOutObj.num4);
		assertEquals(expNumAvgOutObj.num5, actNumAvgOutObj.num5);
		assertEquals(expNumAvgOutObj.Average, actNumAvgOutObj.Average);
	}
	
	public void testNumAvgScenario2() {
		
		//1) Input
		NumAvgInp NumAvgInpObj = new NumAvgInp();
		NumAvgInpObj.num1 = 100;
		NumAvgInpObj.num2 = 1000;
		NumAvgInpObj.num3 = 10000;
		NumAvgInpObj.num4 = 1001;
		NumAvgInpObj.num5 = 101;
		
		//2) Expected Output
		NumAvgOut expNumAvgOutObj = new NumAvgOut();
		expNumAvgOutObj.num1 = 100;
		expNumAvgOutObj.num2 = 1000;
		expNumAvgOutObj.num3 = 10000;
		expNumAvgOutObj.num4 = 1001;
		expNumAvgOutObj.num5 = 101;
		expNumAvgOutObj.Average = 2440.4;
		
		//3) Actual Output
		NumAvgOut actNumAvgOutObj = NumAvgObj.NumberAvg(NumAvgInpObj);
		
		//4) Assertions
		assertEquals(expNumAvgOutObj.num1, actNumAvgOutObj.num1);
		assertEquals(expNumAvgOutObj.num2, actNumAvgOutObj.num2);
		assertEquals(expNumAvgOutObj.num3, actNumAvgOutObj.num3);
		assertEquals(expNumAvgOutObj.num4, actNumAvgOutObj.num4);
		assertEquals(expNumAvgOutObj.num5, actNumAvgOutObj.num5);
		assertEquals(expNumAvgOutObj.Average, actNumAvgOutObj.Average);
	}
	
	public void testNumAvgScenario3() {
		
		//1) Input
		NumAvgInp NumAvgInpObj = new NumAvgInp();
		NumAvgInpObj.num1 = 455;
		NumAvgInpObj.num2 = 456;
		NumAvgInpObj.num3 = 556;
		NumAvgInpObj.num4 = 134567;
		NumAvgInpObj.num5 = 3456789;
		
		//2) Expected Output
		NumAvgOut expNumAvgOutObj = new NumAvgOut();
		expNumAvgOutObj.num1 = 455;
		expNumAvgOutObj.num2 = 456;
		expNumAvgOutObj.num3 = 556;
		expNumAvgOutObj.num4 = 134567;
		expNumAvgOutObj.num5 = 3456789;
		expNumAvgOutObj.Average = 718564.6;
		
		//3) Actual Output
		NumAvgOut actNumAvgOutObj = NumAvgObj.NumberAvg(NumAvgInpObj);
		
		//4) Assertions
		assertEquals(expNumAvgOutObj.num1, actNumAvgOutObj.num1);
		assertEquals(expNumAvgOutObj.num2, actNumAvgOutObj.num2);
		assertEquals(expNumAvgOutObj.num3, actNumAvgOutObj.num3);
		assertEquals(expNumAvgOutObj.num4, actNumAvgOutObj.num4);
		assertEquals(expNumAvgOutObj.num5, actNumAvgOutObj.num5);
		assertEquals(expNumAvgOutObj.Average, actNumAvgOutObj.Average);
	}
	
}
