package com.indus.training.core.domain;

public class DistanceConvOut {
	private double Kilometers;
	private double Meters;
	private String convType;
	
	public void setKilometers(double d) {
		Kilometers = d;
	}
	public double getKilometers() {
		return Kilometers;	
	}
	
	public void setMeters(double d) {
		Meters = d;
	}
	public double getMeters() {
		return Meters;
	}
	
	public void setConvType(String d) {
		convType = d;
	}
	public String getConvType() {
		return convType;
	}
}
