package com.indus.training.core.svc;

import com.indus.training.core.domain.TempInput;
import com.indus.training.core.domain.TempOutput;
import com.indus.training.core.impl.TempConv;

import junit.framework.TestCase;

public class test_TempConv extends TestCase {

	private TempConv tempConvObj;

	protected void setUp() throws Exception {
		tempConvObj = new TempConv();
	}

	protected void tearDown() throws Exception {
		tempConvObj = null;
	}
	
	public void testCelsiusConvScenario1() {
		
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.temperature = 25.0;		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.givenTemp = 25.0;
		expTempOutObj.conversionType = "Celsius"; 
		expTempOutObj.convTemp = 77.0; 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.CelsiusConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.givenTemp, actTempOutObj.givenTemp);
		assertEquals(expTempOutObj.conversionType, actTempOutObj.conversionType);
		assertEquals(expTempOutObj.convTemp, actTempOutObj.convTemp);
		
	}
	
	public void testCelsiusConvScenario2() {
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.temperature = 0.0;		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.givenTemp = 0.0;
		expTempOutObj.conversionType = "Celsius"; 
		expTempOutObj.convTemp = 32.0; 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.CelsiusConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.givenTemp, actTempOutObj.givenTemp);
		assertEquals(expTempOutObj.conversionType, actTempOutObj.conversionType);
		assertEquals(expTempOutObj.convTemp, actTempOutObj.convTemp);
		
	}
	
	public void testCelsiusConvScenario3() {
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.temperature = -3.0;		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.givenTemp = -3.0;
		expTempOutObj.conversionType = "Celsius"; 
		expTempOutObj.convTemp = 27.0; 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.CelsiusConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.givenTemp, actTempOutObj.givenTemp);
		assertEquals(expTempOutObj.conversionType, actTempOutObj.conversionType);
		assertEquals(expTempOutObj.convTemp, actTempOutObj.convTemp);
		
	}

	public void testFahrenhietConvScenario1() {
		
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.temperature = 77.0;		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.givenTemp = 77.0;
		expTempOutObj.conversionType = "Fahrenhiet"; 
		expTempOutObj.convTemp = 25.0; 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.FahrenhietConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.givenTemp, actTempOutObj.givenTemp);
		assertEquals(expTempOutObj.conversionType, actTempOutObj.conversionType);
		assertEquals(expTempOutObj.convTemp, actTempOutObj.convTemp);
		
	}
	
	public void testFahrenhietConvScenario2() {
		
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.temperature = 0.0;		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.givenTemp = 0.0;
		expTempOutObj.conversionType = "Fahrenhiet"; 
		expTempOutObj.convTemp = -18.0; 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.FahrenhietConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.givenTemp, actTempOutObj.givenTemp);
		assertEquals(expTempOutObj.conversionType, actTempOutObj.conversionType);
		assertEquals(expTempOutObj.convTemp, actTempOutObj.convTemp);
	}
	
	public void testFahrenhietConvScenario3() {
		
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.temperature = -21.0;		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.givenTemp = -21.0;
		expTempOutObj.conversionType = "Fahrenhiet"; 
		expTempOutObj.convTemp = -29.0; 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.FahrenhietConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.givenTemp, actTempOutObj.givenTemp);
		assertEquals(expTempOutObj.conversionType, actTempOutObj.conversionType);
		assertEquals(expTempOutObj.convTemp, actTempOutObj.convTemp);
		
	}
}
