package com.indus.training.core.impl;

import com.indus.training.core.domain.TempInput;
import com.indus.training.core.domain.TempOutput;
import com.indus.training.core.svc.TemperatureConversion;

public class TempConv implements TemperatureConversion {

	@Override
	public TempOutput CelsiusConv(TempInput TempInpObj) {
		// TODO Auto-generated method stub
		TempOutput TempOutObj = new TempOutput();
		double GivenTemp = TempInpObj.getTemperature();
		double ConvTemp = (GivenTemp * 9 / 5) + 32;
		TempOutObj.setGivenTemp(GivenTemp);
		TempOutObj.setConversionType("Celsius") ;
		TempOutObj.setConvTemp(Math.round(ConvTemp));
		return TempOutObj;
	}
		
	public TempOutput FahrenhietConv(TempInput TempInpObj) {
		// TODO Auto-generated method stub
		TempOutput TempOutObj = new TempOutput();
		double GivenTemp = TempInpObj.getTemperature();
		double ConvTemp = (GivenTemp - 32) * 5 / 9;
		TempOutObj.setGivenTemp(GivenTemp);
		TempOutObj.setConversionType("Fahrenhiet");
		TempOutObj.setConvTemp(Math.round(ConvTemp)); 
		
		return TempOutObj;
	}

}
