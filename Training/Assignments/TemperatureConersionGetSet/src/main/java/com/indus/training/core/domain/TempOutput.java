package com.indus.training.core.domain;

public class TempOutput {
	private double givenTemp;
	private String conversionType;
	private double convTemp;
	
	public void setGivenTemp(double d) {
		givenTemp = d;
	}
	
	public double getGivenTemp() {
		return givenTemp;
	}
	
	public void setConversionType(String d) {
		conversionType = d;
	}
	
	public String getConversionType() {
		return conversionType;
	}
	
	public void setConvTemp(double d) {
		convTemp = d;
	}
	
	public double getConvTemp() {
		return convTemp;
	}
}
