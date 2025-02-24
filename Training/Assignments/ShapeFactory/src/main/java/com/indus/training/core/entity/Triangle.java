package com.indus.training.core.entity;


import com.indus.training.core.svc.Shape;

public class Triangle implements Shape {

    @Override
    public ShapeOuput calculateArea(ShapeInput input) {
        // Validate input
        if (input.getDimensions().length != 2) {
            throw new IllegalArgumentException("Triangle requires exactly 2 dimensions (base and height).");
        }

        double base = input.getDimensions()[0];
        double height = input.getDimensions()[1];
        double area = 0.5 * base * height;
        return new ShapeOuput("Triangle", area);
    }
}
