package com.indus.training.core.entity;

import com.indus.training.core.svc.Shape;

public class Circle implements Shape {

    @Override
    public ShapeOuput calculateArea(ShapeInput input) {
        // Validate input
        if (input.getDimensions().length != 1) {
            throw new IllegalArgumentException("Circle requires exactly 1 dimension (radius).");
        }

        double radius = input.getDimensions()[0];
        double area = Math.PI * radius * radius;
        return new ShapeOuput("Circle", area);
    }
}
