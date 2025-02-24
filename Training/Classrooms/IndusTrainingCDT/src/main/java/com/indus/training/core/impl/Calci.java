package com.indus.training.core.impl;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOutput;
import com.indus.training.core.svc.ICalci;

public class Calci implements ICalci {

	@Override
	public CalcOutput add(CalcInput CalcInObj) {
		// TODO Auto-generated method stub
		CalcOutput CalOutObj = new CalcOutput();
		{
			double param1 = CalcInObj.param1;
			double param2 = CalcInObj.param2;
			double result = param1 + param2;
			CalOutObj.param1 = param1;
			CalOutObj.param2 = param2;
			CalOutObj.result = result;
			CalOutObj.operation = "Add";
		}
		return CalOutObj;
	}

	@Override
	public CalcOutput sub(CalcInput CalcInObj) {
		// TODO Auto-generated method stub
		CalcOutput CalOutObj = new CalcOutput();
		{
			double param1 = CalcInObj.param1;
			double param2 = CalcInObj.param2;
			double result = param1 - param2;
			CalOutObj.param1 = param1;
			CalOutObj.param2 = param2;
			CalOutObj.result = result;
			CalOutObj.operation = "Sub";
		}
		return CalOutObj;
	}

	@Override
	public CalcOutput mul(CalcInput CalcInObj) {
		// TODO Auto-generated method stub
		CalcOutput calOutObj = new CalcOutput();
		{
			double param1 = CalcInObj.param1;
			double param2 = CalcInObj.param2;
			double result = param1 * param2;
			calOutObj.param1 = param1;
			calOutObj.param2 = param2;
			calOutObj.result = result;
			calOutObj.operation = "Mul";
		}
		return calOutObj;
	}

	@Override
	public CalcOutput div(CalcInput CalcInObj) {
		// TODO Auto-generated method stub
		CalcOutput calOutObj = new CalcOutput();
		{
			double param1 = CalcInObj.param1;
			double param2 = CalcInObj.param2;
			double result = param1 / param2;
			calOutObj.param1 = param1;
			calOutObj.param2 = param2;
			calOutObj.result = result;
			calOutObj.operation = "Div";
		}
		return calOutObj;
	}

}
