package com.indus.training.core.impl;

import com.indus.training.core.svc.Shape;

public class Square extends Shape {
    @Override
    public String calculateProperties(double side) {
        double area = side * side;
        double perimeter = 4 * side;
        return "Square Dimension: " + side + ", Area: " + area + ", Perimeter: " + perimeter;
    }
}
