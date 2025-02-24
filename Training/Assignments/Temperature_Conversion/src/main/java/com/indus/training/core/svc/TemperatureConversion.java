package com.indus.training.core.svc;

import com.indus.training.core.domain.TempInput;
import com.indus.training.core.domain.TempOutput;

public interface TemperatureConversion {
	public TempOutput CelsiusConv(TempInput TempInpObj);
	public TempOutput FahrenhietConv(TempInput TempInpObj);
}
