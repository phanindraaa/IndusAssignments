package com.indus.training.core.svc;
import com.indus.training.core.domain.CalcInput;
public interface CalcInterface {
	public static double Addition() {
		double param1 = CalcInput.param1;
		double param2  = CalcInput.param2;
		double Result =  param1 + param2;
		return Result;
	}
}	
