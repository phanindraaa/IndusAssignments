package com.indus.training.spring.impl;

import com.indus.training.spring.entity.CalcInput;
import com.indus.training.spring.entity.CalcOutput;
import com.indus.training.spring.svc.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public CalcOutput add(CalcInput input) {
		// TODO Auto-generated method stub
		double result = input.getParam1() + input.getParam2();
		CalcOutput output = new CalcOutput();
		output.setParam1(input.getParam1());
		output.setParam2(input.getParam2());
		output.setResult(result);
		return output;
	}

	@Override
	public CalcOutput subtract(CalcInput input) {
		// TODO Auto-generated method stub
		double result = input.getParam1() - input.getParam2();
		CalcOutput output = new CalcOutput();
		output.setParam1(input.getParam1());
		output.setParam2(input.getParam2());
		output.setResult(result);
		return output;
	}

	@Override
	public CalcOutput multiply(CalcInput input) {
		// TODO Auto-generated method stub
		double result = input.getParam1() * input.getParam2();
		CalcOutput output = new CalcOutput();
		output.setParam1(input.getParam1());
		output.setParam2(input.getParam2());
		output.setResult(result);
		return output;
	}

	@Override
	public CalcOutput divide(CalcInput input) {
		// TODO Auto-generated method stub
		double result = input.getParam1() / input.getParam2();
		CalcOutput output = new CalcOutput();
		output.setParam1(input.getParam1());
		output.setParam2(input.getParam2());
		output.setResult(result);
		return output;
	}

}
