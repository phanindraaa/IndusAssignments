package com.indus.training.core.domain;

public class PriceInput {
	
	private int size; 
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private double[] arr = new double[size];

	public double[] getArr() {
		return arr;
	}

	public void setArr(double[] arr) {
		this.arr = arr;
	}

}
