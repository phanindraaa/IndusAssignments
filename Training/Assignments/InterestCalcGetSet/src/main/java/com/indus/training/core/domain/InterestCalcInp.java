package com.indus.training.core.domain;

public class InterestCalcInp {
	private double Principal;
	private double TimePeriod;
	private double RateOfInterest;
	
	public void setPrincipal(double d) {
		Principal = d;
	}
	public double getPrincipal() {
		return Principal;
	}
	
	public void setTimePeriod(double d) {
		TimePeriod = d;
	}
	public double getTimePeriod() {
		return TimePeriod;
	}
	
	public void setRateOfInterest(double d) {
		RateOfInterest = d;
	}
	public double getRateOfInterest() {
		return RateOfInterest;
	}
}
