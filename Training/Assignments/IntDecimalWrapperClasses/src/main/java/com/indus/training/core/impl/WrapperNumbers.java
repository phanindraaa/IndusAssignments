package com.indus.training.core.impl;

public class WrapperNumbers {
    private Integer intValue;
    private Double doubleValue;
    private Integer intResult;
    private Double doubleResult;

    // Constructor to initialize the WrapperNumbers with Integer and Double values
    @SuppressWarnings("removal")
	public WrapperNumbers(Integer intValue, Double doubleValue, Integer intResult, Double doubleResult) {
        this.intValue = new Integer(intValue); //constructor depraticated
        this.doubleValue = new Double(doubleValue);
        this.doubleResult = null;
        this.intResult = null;
    }

    // Method to add another Integer to the current intValue
    public void addInteger(Integer value) {
    	Integer Param1 = this.intValue;
    	Integer Param2 = value;
    	intResult = Param1 + Param2;
         // Integer addition
    }

    // Method to add another Double to the current doubleValue
    public void addDouble(Double value) {
    	Double Param1 = this.doubleValue;
    	Double Param2 = value;
    	doubleResult = Param1 + Param2;
    }

    // Getters for the values
    public Integer getIntValue() {
        return intResult;
    }

    public Double getDoubleValue() {
        return doubleResult;
    }
}
