package com.indus.training.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.indus.training.spring.entity.CalcInput;
import com.indus.training.spring.entity.CalcOutput;
import com.indus.training.spring.svc.CalculatorService;

public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    public CalcOutput add( CalcInput input) {
        return calculatorService.add(input);
    }

    public CalcOutput subtract( CalcInput input) {
        return calculatorService.subtract(input);
    }

    public CalcOutput multiply( CalcInput input) {
        return calculatorService.multiply(input);
    }

    public CalcOutput divide( CalcInput input) {
        return calculatorService.divide(input);
    }
}
