package com.indus.training.spring.test;

import org.junit.Before;
import org.junit.Test;
import com.indus.training.spring.entity.CalcInput;
import com.indus.training.spring.entity.CalcOutput;
import com.indus.training.spring.impl.CalculatorServiceImpl;
import com.indus.training.spring.svc.CalculatorService;

import static org.junit.Assert.*;

public class testCalc {

    private CalculatorService calculatorService;

    @Before
    public void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

	@Test
    public void testAdd() {
        CalcInput input = new CalcInput(5, 3);
        CalcOutput result = calculatorService.add(input);
        assertEquals(8, result.getResult(), 0.1);
    }

	@Test
    public void testSubtract() {
        CalcInput input = new CalcInput(5, 3);
        CalcOutput result = calculatorService.subtract(input);
        assertEquals(2, result.getResult(), 0.1);
    }

	@Test
    public void testMultiply() {
        CalcInput input = new CalcInput(5, 3);
        CalcOutput result = calculatorService.multiply(input);
        assertEquals(15, result.getResult(), 0.1);
    }

	@Test
    public void testDivide() {
        CalcInput input = new CalcInput(6, 3);
        CalcOutput result = calculatorService.divide(input);
        assertEquals(2, result.getResult(), 0.1);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        CalcInput input = new CalcInput(6, 0);
        calculatorService.divide(input);
    }
}
