package com.indus.training.core.domain;

public class PriceOutput {
	
	private double[] arrActual;
	private double[] arrSorted;
	private long timeTakenForSorting;

	public long getTimeTakenForSorting() {
		return timeTakenForSorting;
	}

	public void setTimeTakenForSorting(long timeTakenForSorting) {
		this.timeTakenForSorting = timeTakenForSorting;
	}

	public double[] getArrActual() {
		return arrActual;
	}

	public void setArrActual(double[] arrActual) {
		this.arrActual = arrActual;
	}

	public double[] getArrSorted() {
		return arrSorted;
	}

	public void setArrSorted(double[] arrSorted) {
		this.arrSorted = arrSorted;
	}

}
