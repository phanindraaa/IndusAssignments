package com.indus.training.core.entity;

public class ShapeOuput {
	private String shapeType;
	private double area;
	
	public ShapeOuput(String shapeType, double area) {
		this.setShapeType(shapeType);
		this.setArea(area);
	}

	public String getShapeType() {
		return shapeType;
	}

	public void setShapeType(String shapeType) {
		this.shapeType = shapeType;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
}
