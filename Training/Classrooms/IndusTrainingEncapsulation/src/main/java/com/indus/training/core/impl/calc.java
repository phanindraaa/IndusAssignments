package com.indus.training.core.impl;

import com.indus.training.core.svc.ICalci;

public class calc implements ICalci{
	
	public double addition(double param1, double param2) {
		double result = 0;
		result = param1 + param2;
		return result;	
	}
	
	public double subtract(double param1, double param2) {
		double result = 0;
		result = param1 - param2;
		return result;
	}
	
	public double multiply(double param1, double param2) {
		double result = 0;
		result = param1 * param2;
		return result;
	}
	
	public double division(double param1, double param2) {
		double result = 0;
		result = param1 / param2;
		return result;
	}

}
