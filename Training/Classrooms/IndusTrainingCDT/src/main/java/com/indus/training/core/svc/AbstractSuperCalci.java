package com.indus.training.core.svc;

public abstract class AbstractSuperCalci {
	public double Addition(double Param1, double Param2) {
		double Result = 0.0;
		Result = Param1 + Param2;
		return Result;
	}
	
	public abstract double Subtraction(double Param1, double Param2);
//		double Result = 0.0;
//		Result = Param1 - Param2;
//		return Result;
//	}
}
