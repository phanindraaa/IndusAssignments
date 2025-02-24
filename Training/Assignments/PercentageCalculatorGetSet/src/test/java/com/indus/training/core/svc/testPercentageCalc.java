package com.indus.training.core.svc;

import com.indus.training.core.domain.PercentageCalcInp;
import com.indus.training.core.domain.PercentageCalcOut;
import com.indus.training.core.impl.PercentageCalc;

import junit.framework.TestCase;

public class testPercentageCalc extends TestCase {

	private PercentageCalc PercentageCalcObj;

	protected void setUp() throws Exception {
		PercentageCalcObj = new PercentageCalc();
	}

	protected void tearDown() throws Exception {
		PercentageCalcObj = null;
	}

	public void testPercentageCalcScenario1() {

		// 1) Input
		PercentageCalcInp PercentageCalcInpObj = new PercentageCalcInp();
		PercentageCalcInpObj.setMarksObtained(400);
		PercentageCalcInpObj.setTotalMarks(500);

		// 2) Expected Output
		PercentageCalcOut expPercentageCalcOutObj = new PercentageCalcOut();
		expPercentageCalcOutObj.setMarksObtained(400);
		expPercentageCalcOutObj.setTotalMarks(500);
		expPercentageCalcOutObj.setPercentage(80);

		// 3) Actual Output
		PercentageCalcOut actPercentageCalcOutObj = PercentageCalcObj.PercentCalc(PercentageCalcInpObj);

		// 4) Assertions
		assertEquals(expPercentageCalcOutObj.getMarksObtained(), actPercentageCalcOutObj.getMarksObtained());
		assertEquals(expPercentageCalcOutObj.getTotalMarks(), actPercentageCalcOutObj.getTotalMarks());
		assertEquals(expPercentageCalcOutObj.getPercentage(), actPercentageCalcOutObj.getPercentage());
		
	}

}
