package com.indus.training.core.impl;

import com.indus.training.core.domain.AreaCalcInput;
import com.indus.training.core.domain.AreaCalcOutput;
import com.indus.training.core.svc.AreaCalculator;

public class AreaCalc implements AreaCalculator {

	@Override
	public AreaCalcOutput calculateCircleArea(AreaCalcInput AreaCalcInpObj) {
		// TODO Auto-generated method stub
		AreaCalcOutput AreaCalcOutObj = new AreaCalcOutput();
		double radius = AreaCalcInpObj.radius;
		double CircleArea = Math.round(Math.PI * radius * radius);
		AreaCalcOutObj.Area = CircleArea;
		AreaCalcOutObj.radius = radius;
		return AreaCalcOutObj;
	}

	@Override
	public AreaCalcOutput calculateTriangleArea(AreaCalcInput AreaCalcInpObj) {
		// TODO Auto-generated method stub
		AreaCalcOutput AreaCalcOutObj = new AreaCalcOutput();
		double base = AreaCalcInpObj.base;
		double height = AreaCalcInpObj.height;
		double TriangleArea = 0.5 * base * height;
		AreaCalcOutObj.Area = TriangleArea;
		AreaCalcOutObj.base = base;
		AreaCalcOutObj.height = height;
		return AreaCalcOutObj;
	}

	@Override
	public AreaCalcOutput calculateSquareArea(AreaCalcInput AreaCalcInpObj) {
		// TODO Auto-generated method stub
		AreaCalcOutput AreaCalcOutObj = new AreaCalcOutput();
		double side = AreaCalcInpObj.side;
		double SquareArea = side * side;;
		AreaCalcOutObj.Area = SquareArea;
		AreaCalcOutObj.side = side;
		return AreaCalcOutObj;
	}

}
