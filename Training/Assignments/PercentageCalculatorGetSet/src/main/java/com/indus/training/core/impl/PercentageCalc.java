package com.indus.training.core.impl;

import com.indus.training.core.domain.PercentageCalcInp;
import com.indus.training.core.domain.PercentageCalcOut;
import com.indus.training.core.svc.PercentageCalcInterface;

public class PercentageCalc implements PercentageCalcInterface {

	@Override
	public PercentageCalcOut PercentCalc(PercentageCalcInp PercentageCalcInpObj) {
		// TODO Auto-generated method stub
		PercentageCalcOut PercentageCalcOutObj = new PercentageCalcOut();
		double ObtainedMarks = PercentageCalcInpObj.getMarksObtained();
		double TotalMarks = PercentageCalcInpObj.getTotalMarks();
		double Percentage = ObtainedMarks/TotalMarks * 100;
		PercentageCalcOutObj.setMarksObtained(ObtainedMarks);
		PercentageCalcOutObj.setTotalMarks(TotalMarks);
		PercentageCalcOutObj.setPercentage(Percentage);
		return PercentageCalcOutObj;
	}

}
