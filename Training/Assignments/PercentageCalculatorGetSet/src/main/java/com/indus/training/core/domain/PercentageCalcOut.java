package com.indus.training.core.domain;

public class PercentageCalcOut {
	private double MarksObtained;
	private double TotalMarks;
	private double Percentage;
	
	public void setMarksObtained(double d) {
		MarksObtained = d;
	}
	public double getMarksObtained() {
		return MarksObtained;
	}
	
	public void setTotalMarks(double d) {
		TotalMarks = d;
	}
	public double getTotalMarks() {
		return TotalMarks;
	}
	
	public void setPercentage(double d) {
		Percentage = d;
	}
	public double getPercentage() {
		return Percentage;
	}
}
