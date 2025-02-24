package com.indus.training.core.svc;

import com.indus.training.core.domain.TempInput;
import com.indus.training.core.domain.TempOutput;
import com.indus.training.core.impl.TempConv;

import junit.framework.TestCase;

public class testTempConv extends TestCase {

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
		TempInpObj.setTemperature(25.0);		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.setGivenTemp(25.0);
		expTempOutObj.setConversionType("Celsius"); 
		expTempOutObj.setConvTemp(77.0); 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.CelsiusConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.getGivenTemp(), actTempOutObj.getGivenTemp());
		assertEquals(expTempOutObj.getConversionType(), actTempOutObj.getConversionType());
		assertEquals(expTempOutObj.getConvTemp(), actTempOutObj.getConvTemp());
		
	}
	
	public void testCelsiusConvScenario2() {
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.setTemperature(0.0);		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.setGivenTemp(0.0);
		expTempOutObj.setConversionType("Celsius"); 
		expTempOutObj.setConvTemp(32.0); 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.CelsiusConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.getGivenTemp(), actTempOutObj.getGivenTemp());
		assertEquals(expTempOutObj.getConversionType(), actTempOutObj.getConversionType());
		assertEquals(expTempOutObj.getConvTemp(), actTempOutObj.getConvTemp());
		
	}
	
	public void testCelsiusConvScenario3() {
		//1) Input
				TempInput TempInpObj = new TempInput();
				TempInpObj.setTemperature(-3.0);		
				//2) ExpectedOutput
				TempOutput expTempOutObj = new TempOutput();
				expTempOutObj.setGivenTemp(-3.0);
				expTempOutObj.setConversionType("Celsius"); 
				expTempOutObj.setConvTemp(27.0); 
				
				//3) ActualOutput
				TempOutput actTempOutObj = tempConvObj.CelsiusConv(TempInpObj);
				
				//4) Assertions
				assertEquals(expTempOutObj.getGivenTemp(), actTempOutObj.getGivenTemp());
				assertEquals(expTempOutObj.getConversionType(), actTempOutObj.getConversionType());
				assertEquals(expTempOutObj.getConvTemp(), actTempOutObj.getConvTemp());
		
	}

	public void testFahrenhietConvScenario1() {
		
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.setTemperature(77.0);		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.setGivenTemp(77.0);
		expTempOutObj.setConversionType("Fahrenhiet"); 
		expTempOutObj.setConvTemp(25.0); 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.FahrenhietConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.getGivenTemp(), actTempOutObj.getGivenTemp());
		assertEquals(expTempOutObj.getConversionType(), actTempOutObj.getConversionType());
		assertEquals(expTempOutObj.getConvTemp(), actTempOutObj.getConvTemp());
		
	}
	
	public void testFahrenhietConvScenario2() {
		
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.setTemperature(0.0);		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.setGivenTemp(0.0);
		expTempOutObj.setConversionType("Fahrenhiet"); 
		expTempOutObj.setConvTemp(-18.0); 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.FahrenhietConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.getGivenTemp(), actTempOutObj.getGivenTemp());
		assertEquals(expTempOutObj.getConversionType(), actTempOutObj.getConversionType());
		assertEquals(expTempOutObj.getConvTemp(), actTempOutObj.getConvTemp());
		
	}
	
	public void testFahrenhietConvScenario3() {
		
		//1) Input
		TempInput TempInpObj = new TempInput();
		TempInpObj.setTemperature(-21.0);		
		//2) ExpectedOutput
		TempOutput expTempOutObj = new TempOutput();
		expTempOutObj.setGivenTemp(-21.0);
		expTempOutObj.setConversionType("Fahrenhiet"); 
		expTempOutObj.setConvTemp(-29.0); 
		
		//3) ActualOutput
		TempOutput actTempOutObj = tempConvObj.FahrenhietConv(TempInpObj);
		
		//4) Assertions
		assertEquals(expTempOutObj.getGivenTemp(), actTempOutObj.getGivenTemp());
		assertEquals(expTempOutObj.getConversionType(), actTempOutObj.getConversionType());
		assertEquals(expTempOutObj.getConvTemp(), actTempOutObj.getConvTemp());
		
	}
}
