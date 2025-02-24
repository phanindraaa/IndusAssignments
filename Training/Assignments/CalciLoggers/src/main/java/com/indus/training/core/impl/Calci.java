package com.indus.training.core.impl;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOuput;
import com.indus.training.core.exception.CalculationException;
import com.indus.training.core.exception.DivisionByZeroException;
import com.indus.training.core.svc.CalcOutput;
import com.indus.training.core.svc.ICalci;

public class Calci implements ICalci {

    @Override
    public CalcOutput Addition(CalcInput CalInObj) throws CalculationException {
        validateInput(CalInObj);

        try {
            CalcOutput calOutObj = new CalcOutput();
            double Param1 = CalInObj.getParam1();
            double Param2 = CalInObj.getParam2();
        	double Result = Param1 + Param2;
        	calOutObj.setParam1(Param1);
        	calOutObj.setParam2(Param2);
        	calOutObj.setResult(Result);
//            calOutObj.se
        	return calOutObj;
        } catch (Exception e) {
            throw new CalculationException("Error during addition calculation");
        }
    }


    @Override
    public CalcOutput Subtract(CalcInput CalInObj) throws CalculationException {
        validateInput(CalInObj);

        try {
        	 CalcOutput calOutObj = new CalcOutput();
             double Param1 = CalInObj.getParam1();
             double Param2 = CalInObj.getParam2();
         	double Result = Param1 - Param2;
         	calOutObj.setParam1(Param1);
         	calOutObj.setParam2(Param2);
         	calOutObj.setResult(Result);
//             calOutObj.se
         	return calOutObj;
        } catch (ArithmeticException e) {
            throw new CalculationException("Error during addition calculation");
        }
    }


    @Override
    public CalcOutput Multiply(CalcInput CalInObj) throws CalculationException {
    	 CalcOutput calOutObj = new CalcOutput();
         double Param1 = CalInObj.getParam1();
         double Param2 = CalInObj.getParam2();
     	double Result = Param1 * Param2;
     	calOutObj.setParam1(Param1);
     	calOutObj.setParam2(Param2);
     	calOutObj.setResult(Result);
//         calOutObj.se
     	return calOutObj;
    }

    @Override
    public CalcOutput Division(CalcInput CalInObj) throws CalculationException, DivisionByZeroException {
        validateInput(CalInObj);

        if (CalInObj.getParam2() == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed");
        }

        try {
        	 CalcOutput calOutObj = new CalcOutput();
             double Param1 = CalInObj.getParam1();
             double Param2 = CalInObj.getParam2();
         	double Result = Param1 / Param2;
         	calOutObj.setParam1(Param1);
         	calOutObj.setParam2(Param2);
         	calOutObj.setResult(Result);
//             calOutObj.se
         	return calOutObj;
        } catch (Exception e) {
            throw new CalculationException("Error during division calculation");
        }
    }

    private void validateInput(CalcInput calInpObj) throws CalculationException {
        if (calInpObj == null) {
            throw new CalculationException("Invalid input Parameters");
        }
    }

}
