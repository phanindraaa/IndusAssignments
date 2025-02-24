package com.indus.training.core.impl;

import com.indus.training.core.domain.InterestCalcInp;
import com.indus.training.core.domain.InterestCalcOut;
import com.indus.training.core.svc.InterestCalcInterface;

public class InterestCalci implements InterestCalcInterface {

	@Override
	public InterestCalcOut InterestCalc(InterestCalcInp InterestCalcInpObj) {
		// TODO Auto-generated method stub
		InterestCalcOut InterestCalcOutObj = new InterestCalcOut();
		double Principal = InterestCalcInpObj.getPrincipal();
		double TimePeriod = InterestCalcInpObj.getTimePeriod();
		double RateOfInterest = InterestCalcInpObj.getRateOfInterest();
		double InterestAmount = Principal * RateOfInterest * TimePeriod / 100;
		InterestCalcOutObj.setPrincipal(Principal);
		InterestCalcOutObj.setRateOfInterest(RateOfInterest);
		InterestCalcOutObj.setTimePeriod(TimePeriod);
		InterestCalcOutObj.setInterestAmount(InterestAmount);
		return InterestCalcOutObj;
	}

}
