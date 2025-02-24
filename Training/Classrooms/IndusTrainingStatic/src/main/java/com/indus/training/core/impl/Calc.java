package com.indus.training.core.impl;

import com.indus.training.core.domain.CalcInput;

public class Calc {
	public static double Subtract() {
		double param1 = CalcInput.param1;
		double param2  = CalcInput.param2;
		double Result =  param1 - param2;
		return Result;
		
	}
}
