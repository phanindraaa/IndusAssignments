package com.indus.training.core.svc;

import com.indus.training.core.domain.NumAvgInp;
import com.indus.training.core.domain.NumAvgOut;
import com.indus.training.core.impl.NumAvg;

import junit.framework.TestCase;

public class testAvgNum extends TestCase {

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
		NumAvgInpObj.setNum1(3.0);
		NumAvgInpObj.setNum2(6.0);
		NumAvgInpObj.setNum3(9.0);
		NumAvgInpObj.setNum4(12.0);
		NumAvgInpObj.setNum5(15.0);
		
		//2) Expected Output
		NumAvgOut expNumAvgOutObj = new NumAvgOut();
		expNumAvgOutObj.setNum1(3.0);
		expNumAvgOutObj.setNum2(6.0);
		expNumAvgOutObj.setNum3(9.0);
		expNumAvgOutObj.setNum4(12.0);
		expNumAvgOutObj.setNum5(15.0);
		expNumAvgOutObj.setAverage(9.0);
		
		//3) Actual Output
		NumAvgOut actNumAvgOutObj = NumAvgObj.NumberAvg(NumAvgInpObj);
		
		//4) Assertions
		assertEquals(expNumAvgOutObj.getNum1(), actNumAvgOutObj.getNum1());
		assertEquals(expNumAvgOutObj.getNum2(), actNumAvgOutObj.getNum2());
		assertEquals(expNumAvgOutObj.getNum3(), actNumAvgOutObj.getNum3());
		assertEquals(expNumAvgOutObj.getNum4(), actNumAvgOutObj.getNum4());
		assertEquals(expNumAvgOutObj.getNum5(), actNumAvgOutObj.getNum5());
		assertEquals(expNumAvgOutObj.getAverage(), actNumAvgOutObj.getAverage());
	}
	
	public void testNumAvgScenario2() {
		
		//1) Input
		NumAvgInp NumAvgInpObj = new NumAvgInp();
		NumAvgInpObj.setNum1(100);
		NumAvgInpObj.setNum2(1000);
		NumAvgInpObj.setNum3(10000);
		NumAvgInpObj.setNum4(1001);
		NumAvgInpObj.setNum5(101);
		
		//2) Expected Output
		NumAvgOut expNumAvgOutObj = new NumAvgOut();
		expNumAvgOutObj.setNum1(100);
		expNumAvgOutObj.setNum2(1000);
		expNumAvgOutObj.setNum3(10000);
		expNumAvgOutObj.setNum4(1001);
		expNumAvgOutObj.setNum5(101);
		expNumAvgOutObj.setAverage(2440.4);
		
		//3) Actual Output
		NumAvgOut actNumAvgOutObj = NumAvgObj.NumberAvg(NumAvgInpObj);
		
		//4) Assertions
		assertEquals(expNumAvgOutObj.getNum1(), actNumAvgOutObj.getNum1());
		assertEquals(expNumAvgOutObj.getNum2(), actNumAvgOutObj.getNum2());
		assertEquals(expNumAvgOutObj.getNum3(), actNumAvgOutObj.getNum3());
		assertEquals(expNumAvgOutObj.getNum4(), actNumAvgOutObj.getNum4());
		assertEquals(expNumAvgOutObj.getNum5(), actNumAvgOutObj.getNum5());
		assertEquals(expNumAvgOutObj.getAverage(), actNumAvgOutObj.getAverage());
	}
	
	public void testNumAvgScenario3() {
		
		//1) Input
		NumAvgInp NumAvgInpObj = new NumAvgInp();
		NumAvgInpObj.setNum1(455);
		NumAvgInpObj.setNum2(456);
		NumAvgInpObj.setNum3(556);
		NumAvgInpObj.setNum4(134567);
		NumAvgInpObj.setNum5(3456789);
		
		
		//2) Expected Output
		NumAvgOut expNumAvgOutObj = new NumAvgOut();
		expNumAvgOutObj.setNum1(455);
		expNumAvgOutObj.setNum2(456);
		expNumAvgOutObj.setNum3(556);
		expNumAvgOutObj.setNum4(134567);
		expNumAvgOutObj.setNum5(3456789);
		expNumAvgOutObj.setAverage(718564.6);
		
		//3) Actual Output
		NumAvgOut actNumAvgOutObj = NumAvgObj.NumberAvg(NumAvgInpObj);
		
		//4) Assertions
		assertEquals(expNumAvgOutObj.getNum1(), actNumAvgOutObj.getNum1());
		assertEquals(expNumAvgOutObj.getNum2(), actNumAvgOutObj.getNum2());
		assertEquals(expNumAvgOutObj.getNum3(), actNumAvgOutObj.getNum3());
		assertEquals(expNumAvgOutObj.getNum4(), actNumAvgOutObj.getNum4());
		assertEquals(expNumAvgOutObj.getNum5(), actNumAvgOutObj.getNum5());
		assertEquals(expNumAvgOutObj.getAverage(), actNumAvgOutObj.getAverage());
	}
	
}
