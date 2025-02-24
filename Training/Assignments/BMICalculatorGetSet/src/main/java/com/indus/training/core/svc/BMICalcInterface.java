package com.indus.training.core.svc;

import com.indus.training.core.domain.BMICalcInp;
import com.indus.training.core.domain.BMICalcOut;

public interface BMICalcInterface {
	public BMICalcOut BMICalculator(BMICalcInp BMICalcInpObj);
}
