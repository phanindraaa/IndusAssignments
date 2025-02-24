package com.indus.training.core.domain;

public class InterestCalcOut {
	private double Principal;
	private double TimePeriod;
	private double RateOfInterest;
	private double InterestAmount;
	
	
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
	
	public void setInterestAmount(double d) {
		InterestAmount = d;
	}
	public double getInterestAmount() {
		return InterestAmount;
	}
}
