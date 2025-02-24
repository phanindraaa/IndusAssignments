package com.indus.training.core.svc;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOutput;
import com.indus.training.core.exception.CalculationException;
import com.indus.training.core.exception.DivisionByZeroException;

public interface ICalci {
	public CalcOutput Addition(CalcInput CalInObj) throws CalculationException;
	public CalcOutput Subtract(CalcInput CalInObj) throws CalculationException;
	public CalcOutput Multiply(CalcInput CalInObj) throws CalculationException;
	public CalcOutput Division(CalcInput CalInObj) throws CalculationException, DivisionByZeroException;
}
