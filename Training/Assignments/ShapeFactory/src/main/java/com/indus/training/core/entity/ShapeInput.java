package com.indus.training.core.entity;

public class ShapeInput {	
	private String shapeType;
	private double[] dimensions;
	
	public ShapeInput(String shapeType, double... dimensions ) {
		this.setShapeType(shapeType);
		this.setDimensions(dimensions);
	}

	public double[] getDimensions() {
		return dimensions;
	}

	public void setDimensions(double[] dimensions) {
		this.dimensions = dimensions;
	}

	public String getShapeType() {
		return shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}
}
