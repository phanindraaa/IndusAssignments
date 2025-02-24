package com.indus.training.core.entity;


import com.indus.training.core.svc.Shape;

public class Rectangle implements Shape {

    @Override
    public ShapeOuput calculateArea(ShapeInput input) {
        // Validate input
        if (input.getDimensions().length != 2) {
            throw new IllegalArgumentException("Rectangle requires exactly 2 dimensions (length and width).");
        }

        double length = input.getDimensions()[0];
        double width = input.getDimensions()[1];
        double area = length * width;
        return new ShapeOuput("Rectangle", area);
    }
}
