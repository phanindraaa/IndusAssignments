package com.indus.training.core.impl;

import com.indus.training.core.entity.ShapeInput;
import com.indus.training.core.entity.ShapeOuput;
import com.indus.training.core.exception.ShapeNotFoundException;
import com.indus.training.core.svc.Shape;

public class ShapeImpl {	
	
	private ShapeFactory shapeFactory;
	
	public ShapeImpl(ShapeFactory shapeFactory) {
		this.setShapeFactory(shapeFactory);
	}

	public ShapeFactory getShapeFactory() {
		return shapeFactory;
	}

	public void setShapeFactory(ShapeFactory shapeFactory) {
		this.shapeFactory = shapeFactory;
	}
	
	public ShapeOuput getShapeArea(ShapeInput shapeInput) throws ShapeNotFoundException {
		Shape shape = ShapeFactory.createShape(shapeInput.getShapeType());
		return shape.calculateArea(shapeInput);
		
	}

}
