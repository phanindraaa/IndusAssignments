package com.indus.training.spring.entity;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "calc-input")
public class CalcInput {
    private double operand1;
    private double operand2;
    private String operation;

    // Default no-arg constructor required for JAXB
    public CalcInput() {}

    public CalcInput(double operand1, double operand2, String operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    @XmlElement
    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    @XmlElement
    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    @XmlElement
    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}