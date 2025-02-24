package com.indus.training.core.impl;

import com.indus.training.core.domain.NumAvgInp;
import com.indus.training.core.domain.NumAvgOut;
import com.indus.training.core.svc.NumAvgInterface;

public class NumAvg implements NumAvgInterface {

	@Override
	public NumAvgOut NumberAvg(NumAvgInp NumAvgInpObj) {
		// TODO Auto-generated method stub
		NumAvgOut NumAvgOutObj = new NumAvgOut();
		double num1 = NumAvgInpObj.getNum1();
		double num2 = NumAvgInpObj.getNum2();
		double num3 = NumAvgInpObj.getNum3();
		double num4 = NumAvgInpObj.getNum4();
		double num5 = NumAvgInpObj.getNum5();
		double Sum = num1 + num2 + num3 + num4 + num5;
		double Average = Sum / 5;
		NumAvgOutObj.setNum1(num1);
		NumAvgOutObj.setNum2(num2);
		NumAvgOutObj.setNum3(num3);		
		NumAvgOutObj.setNum4(num4);
		NumAvgOutObj.setNum5(num5);
		NumAvgOutObj.setAverage(Average);
		
		return NumAvgOutObj;
	}

}
