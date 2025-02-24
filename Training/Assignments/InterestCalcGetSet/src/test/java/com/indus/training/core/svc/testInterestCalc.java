package com.indus.training.core.svc;

import com.indus.training.core.domain.InterestCalcInp;
import com.indus.training.core.domain.InterestCalcOut;
import com.indus.training.core.impl.InterestCalci;

import junit.framework.TestCase;

public class testInterestCalc extends TestCase {
	
	private InterestCalci InterestCalciObj;
	protected void setUp() throws Exception {
		InterestCalciObj = new InterestCalci();
	}

	protected void tearDown() throws Exception {
		InterestCalciObj = null;
	}
	
	public void testInterestCalcScenario1() {
		
		//1) Input
		InterestCalcInp InterestcalcInpObj = new InterestCalcInp();
		InterestcalcInpObj.setPrincipal(1000);
		InterestcalcInpObj.setRateOfInterest(2);
		InterestcalcInpObj.setTimePeriod(3);
		
		//2) Expected Output
		InterestCalcOut expInterestCalcOutObj = new InterestCalcOut();
		expInterestCalcOutObj.setPrincipal(1000);
		expInterestCalcOutObj.setRateOfInterest(2);
		expInterestCalcOutObj.setTimePeriod(3);
		expInterestCalcOutObj.setInterestAmount(60);
		
		//3) Actual Output
		InterestCalcOut actInterestCalcOutObj = InterestCalciObj.InterestCalc(InterestcalcInpObj);
		
		//4) Assertions
		assertEquals(expInterestCalcOutObj.getPrincipal(), actInterestCalcOutObj.getPrincipal());
		assertEquals(expInterestCalcOutObj.getRateOfInterest(), actInterestCalcOutObj.getRateOfInterest());
		assertEquals(expInterestCalcOutObj.getTimePeriod(), actInterestCalcOutObj.getTimePeriod());
		assertEquals(expInterestCalcOutObj.getInterestAmount(), actInterestCalcOutObj.getInterestAmount());
		
	}

}
