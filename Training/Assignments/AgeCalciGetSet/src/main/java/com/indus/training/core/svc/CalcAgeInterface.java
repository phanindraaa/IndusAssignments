package com.indus.training.core.svc;

import com.indus.training.core.domain.AgeCalcInp;
import com.indus.training.core.domain.AgeCalciOut;

public interface CalcAgeInterface {
	public AgeCalciOut AgeCalculator(AgeCalcInp AgeCalcInpObj);
}
