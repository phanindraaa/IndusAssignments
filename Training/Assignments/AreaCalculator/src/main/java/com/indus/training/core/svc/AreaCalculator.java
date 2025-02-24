package com.indus.training.core.svc;

import com.indus.training.core.domain.AreaCalcInput;
import com.indus.training.core.domain.AreaCalcOutput;

public interface AreaCalculator {
	public AreaCalcOutput calculateCircleArea(AreaCalcInput AreaCalcInpObj);
	public AreaCalcOutput calculateTriangleArea(AreaCalcInput AreaCalcInpObj);
    public AreaCalcOutput calculateSquareArea(AreaCalcInput AreaCalcInpObj);
}
