package com.indus.training.spring.svc;

import com.indus.training.spring.service.CalcInput;
import com.indus.training.spring.service.ClacOutput;

public interface Calculator {
	public ClacOutput add(CalcInput calcInput);
	public ClacOutput sub(CalcInput calcInput);
	public ClacOutput mul(CalcInput calcInput);
	public ClacOutput div(CalcInput calcInput);
	
}
