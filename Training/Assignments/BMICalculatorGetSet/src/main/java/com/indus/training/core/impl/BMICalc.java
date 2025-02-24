package com.indus.training.core.impl;

import com.indus.training.core.domain.BMICalcInp;
import com.indus.training.core.domain.BMICalcOut;
import com.indus.training.core.svc.BMICalcInterface;

public class BMICalc implements BMICalcInterface {

	@Override
	public BMICalcOut BMICalculator(BMICalcInp BMICalcInpObj) {
		// TODO Auto-generated method stub
		BMICalcOut BMICalcOutObj = new BMICalcOut();
		double weight = BMICalcInpObj.getWeight();
		double height = BMICalcInpObj.getHeight();
		double BMI = weight / (height * height);
		BMICalcOutObj.setWeight(weight);
		BMICalcOutObj.setHeight(height);
		BMICalcOutObj.setBmi(Math.round(BMI));
		return BMICalcOutObj;
	}

}
