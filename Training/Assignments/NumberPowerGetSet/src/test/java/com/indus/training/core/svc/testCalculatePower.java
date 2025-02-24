package com.indus.training.core.svc;

import com.indus.training.core.domain.NumPowerInp;
import com.indus.training.core.domain.NumPowerOut;
import com.indus.training.core.impl.CalculatePower;

import junit.framework.TestCase;

public class testCalculatePower extends TestCase {
	
	private CalculatePower CalcPowerObj;
	protected void setUp() throws Exception {
		CalcPowerObj = new CalculatePower();
	}

	protected void tearDown() throws Exception {
		CalcPowerObj = null;
	}

	public void testCalcPowerScenario1() {
		
		//1) Input
		NumPowerInp NumPowerInpObj = new NumPowerInp();
		NumPowerInpObj.setBase(20.0);
		NumPowerInpObj.setExponent(2.0);
		
		//2) expected Output
		NumPowerOut expNumPowerOutObj = new NumPowerOut();
		expNumPowerOutObj.setBase(20.0);
		expNumPowerOutObj.setExponent(2.0);
		expNumPowerOutObj.setPower(400.0);
		
		//3) Actual Output
		NumPowerOut actNumPowerOutObj = CalcPowerObj.CalcPower(NumPowerInpObj);
		
		//4) Assertions
		assertEquals(expNumPowerOutObj.getBase(), actNumPowerOutObj.getBase());
		assertEquals(expNumPowerOutObj.getExponent(), actNumPowerOutObj.getExponent());
		assertEquals(expNumPowerOutObj.getPower(), actNumPowerOutObj.getPower());	
	}
}
