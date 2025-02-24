package com.indus.training.core.impl;

import com.indus.training.core.domain.NumPowerInp;
import com.indus.training.core.domain.NumPowerOut;
import com.indus.training.core.svc.NumberPowerInterface;

public class CalculatePower implements NumberPowerInterface {

	@Override
	public NumPowerOut CalcPower(NumPowerInp NumPowerInpObj) {
		// TODO Auto-generated method stub
		NumPowerOut NumPowerOutObj = new NumPowerOut();
		double base = NumPowerInpObj.getBase();
		double exponent = NumPowerInpObj.getExponent();
		double power = Math.pow(base, exponent);
		NumPowerOutObj.setBase(base);
		NumPowerOutObj.setExponent(exponent);
		NumPowerOutObj.setPower(power);
		return NumPowerOutObj;
	}

}
