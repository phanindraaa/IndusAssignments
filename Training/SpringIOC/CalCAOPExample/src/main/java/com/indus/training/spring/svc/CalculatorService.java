package com.indus.training.spring.svc;

import com.indus.training.spring.entity.CalcInput;
import com.indus.training.spring.entity.CalcOutput;

public interface CalculatorService {
	    CalcOutput add(CalcInput input);
	    CalcOutput subtract(CalcInput input);
	    CalcOutput multiply(CalcInput input);
	    CalcOutput divide(CalcInput input);
}

