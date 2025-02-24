package com.indus.training.core.svc;

import com.indus.training.core.domain.CalcEncInp;
import com.indus.training.core.domain.CalcEncOut;

public interface CalculatorEncryption {
	
	public CalcEncOut Addition(CalcEncInp CalEncInpObj);
	public CalcEncOut Subtract(CalcEncInp CalEncInpObj);
	public CalcEncOut Multiply(CalcEncInp CalEncInpObj);
	public CalcEncOut Division(CalcEncInp CalEncInpObj);
}
