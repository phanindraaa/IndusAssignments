package com.indus.training.core.svc;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOutput;
/**
 * Interface for basic calculator operations.
 */
public interface Calculator {
	// Adds two numbers. first number, second number(@param) sum of a and b(return)

	public CalcOutput Add(CalcInput CalcInputObj);

	// Sub two numbers. first number, second number(@param) Sub of a and b(return)
	public CalcOutput Subtract(CalcInput CalcInputObj);

	// Multiply two numbers. first number, second number(@param) product of a and
	// b(return)

	public CalcOutput Multiply(CalcInput CalcInputObj);

	// Division two numbers. first number, second number(@param) Division of a and
	// b(return)

	public CalcOutput Divide(CalcInput CalcInputObj);
}
