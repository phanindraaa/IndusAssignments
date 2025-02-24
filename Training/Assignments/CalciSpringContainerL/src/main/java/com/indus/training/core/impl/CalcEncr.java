package com.indus.training.core.impl;

import com.indus.training.core.domain.CalcEncInp;
import com.indus.training.core.domain.CalcEncOut;
import com.indus.training.core.svc.CalculatorEncryption;

public class CalcEncr implements CalculatorEncryption {

	@Override
	public CalcEncOut Addition(CalcEncInp CalEncInpObj) {
		// TODO Auto-generated method stub
		CalcEncOut CalEncOutObj = new CalcEncOut();
		double Param1 = CalEncInpObj.getParam1();
		double Param2 = CalEncInpObj.getParam2();
		double result  = Param1 + Param2;
		CalEncOutObj.setPraam1(Param1);
		CalEncOutObj.setPraam2(Param2);
		CalEncOutObj.setResult(result);
		return CalEncOutObj;
	}

	@Override
	public CalcEncOut Subtract(CalcEncInp CalEncInpObj) {
		// TODO Auto-generated method stub
		CalcEncOut CalEncOutObj = new CalcEncOut();
		double Param1 = CalEncInpObj.getParam1();
		double Param2 = CalEncInpObj.getParam2();
		double result  = Param1 - Param2;
		CalEncOutObj.setPraam1(Param1);
		CalEncOutObj.setPraam2(Param2);
		CalEncOutObj.setResult(result);
		return CalEncOutObj;
	}

	@Override
	public CalcEncOut Multiply(CalcEncInp CalEncInpObj) {
		// TODO Auto-generated method stub
		CalcEncOut CalEncOutObj = new CalcEncOut();
		double Param1 = CalEncInpObj.getParam1();
		double Param2 = CalEncInpObj.getParam2();
		double result  = Param1 * Param2;
		CalEncOutObj.setPraam1(Param1);
		CalEncOutObj.setPraam2(Param2);
		CalEncOutObj.setResult(result);
		return CalEncOutObj;
	}

	@Override
	public CalcEncOut Division(CalcEncInp CalEncInpObj) {
		// TODO Auto-generated method stub
		CalcEncOut CalEncOutObj = new CalcEncOut();
		double Param1 = CalEncInpObj.getParam1();
		double Param2 = CalEncInpObj.getParam2();
		double result  = Param1 / Param2;
		CalEncOutObj.setPraam1(Param1);
		CalEncOutObj.setPraam2(Param2);
		CalEncOutObj.setResult(result);
		return CalEncOutObj;
	}

}
