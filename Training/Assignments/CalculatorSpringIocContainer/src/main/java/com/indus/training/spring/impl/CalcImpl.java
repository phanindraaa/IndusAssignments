package com.indus.training.spring.impl;

import com.indus.training.spring.service.CalcInput;
import com.indus.training.spring.service.ClacOutput;
import com.indus.training.spring.svc.Calculator;

public class CalcImpl implements Calculator {

	@Override
	public ClacOutput add(CalcInput calcInput) {
		// TODO Auto-generated method stub
		double param1 = calcInput.getParam1();
		double param2 = calcInput.getParam2();
		double result = param1 + param2;
		ClacOutput calcOutput = new ClacOutput();
		calcOutput.setParam1(param1);
		calcOutput.setParam2(param2);
		calcOutput.setResult(result);
		return calcOutput;
	}

	@Override
	public ClacOutput sub(CalcInput calcInput) {
		// TODO Auto-generated method stub
		double param1 = calcInput.getParam1();
		double param2 = calcInput.getParam2();
		double result = param1 - param2;
		ClacOutput calcOutput = new ClacOutput();
		calcOutput.setParam1(param1);
		calcOutput.setParam2(param2);
		calcOutput.setResult(result);
		return calcOutput;
	}

	@Override
	public ClacOutput mul(CalcInput calcInput) {
		// TODO Auto-generated method stub
		double param1 = calcInput.getParam1();
		double param2 = calcInput.getParam2();
		double result = param1 * param2;
		ClacOutput calcOutput = new ClacOutput();
		calcOutput.setParam1(param1);
		calcOutput.setParam2(param2);
		calcOutput.setResult(result);
		return calcOutput;
	}

	@Override
	public ClacOutput div(CalcInput calcInput) {
		// TODO Auto-generated method stub
		double param1 = calcInput.getParam1();
		double param2 = calcInput.getParam2();
		double result = param1 / param2;
		ClacOutput calcOutput = new ClacOutput();
		calcOutput.setParam1(param1);
		calcOutput.setParam2(param2);
		calcOutput.setResult(result);
		return calcOutput;
	}

}
