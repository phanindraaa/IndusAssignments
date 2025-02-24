package com.indus.training.core.impl;

import com.indus.training.core.domain.NumAvgInp;
import com.indus.training.core.domain.NumAvgOut;
import com.indus.training.core.svc.NumberAvg;

public class NumAvg implements NumberAvg {

	@Override
	public NumAvgOut NumberAvg(NumAvgInp NumAvgInpObj) {
		// TODO Auto-generated method stub
		NumAvgOut NumAvgOutObj = new NumAvgOut();
		double num1 = NumAvgInpObj.num1;
		double num2 = NumAvgInpObj.num2;
		double num3 = NumAvgInpObj.num3;
		double num4 = NumAvgInpObj.num4;
		double num5 = NumAvgInpObj.num5;
		double Sum = num1 + num2 + num3 + num4 + num5;
		double Average = Sum / 5;
		NumAvgOutObj.num1 = num1;
		NumAvgOutObj.num2 = num2;
		NumAvgOutObj.num3 = num3;
		NumAvgOutObj.num4 = num4;
		NumAvgOutObj.num5 = num5;
		NumAvgOutObj.Average = Average;
		
		return NumAvgOutObj;
	}

}
