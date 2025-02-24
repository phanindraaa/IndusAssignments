package com.indus.training.core.impl;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOutput;
import com.indus.training.core.svc.Calculator;

public class CalculatorImpl implements Calculator {

    @Override
    public CalcOutput Add(CalcInput calcInputObj) {
        // Extract parameters from CalcInput object
        double param1 = calcInputObj.getParam1();
        double param2 = calcInputObj.getParam2();
        
        // Perform addition
        double result = param1 + param2;
        
        // Create and populate CalcOutput object
        CalcOutput output = new CalcOutput();
        output.setParam1(param1);
        output.setParam2(param2);
        output.setResult(result);
        
        // Return result
        return output;
    }

    @Override
    public CalcOutput Subtract(CalcInput calcInputObj) {
        // Extract parameters from CalcInput object
        double param1 = calcInputObj.getParam1();
        double param2 = calcInputObj.getParam2();
        
        // Perform subtraction
        double result = param1 - param2;
        
        // Create and populate CalcOutput object
        CalcOutput output = new CalcOutput();
        output.setParam1(param1);
        output.setParam2(param2);
        output.setResult(result);
        
        // Return result
        return output;
    }

    @Override
    public CalcOutput Multiply(CalcInput calcInputObj) {
        // Extract parameters from CalcInput object
        double param1 = calcInputObj.getParam1();
        double param2 = calcInputObj.getParam2();
        
        // Perform multiplication
        double result = param1 * param2;
        
        // Create and populate CalcOutput object
        CalcOutput output = new CalcOutput();
        output.setParam1(param1);
        output.setParam2(param2);
        output.setResult(result);
        
        // Return result
        return output;
    }

    @Override
    public CalcOutput Divide(CalcInput calcInputObj) {
        // Extract parameters from CalcInput object
        double param1 = calcInputObj.getParam1();
        double param2 = calcInputObj.getParam2();
        
        // Create and populate CalcOutput object
        CalcOutput output = new CalcOutput();
        output.setParam1(param1);
        output.setParam2(param2);
        
        // Perform division, handle division by zero
        if (param2 != 0) {
            double result = param1 / param2;
            output.setResult(result);
        } else {
            output.setResult(Double.NaN); // Indicate division by zero
        }
        
        // Return result
        return output;
    }
}
