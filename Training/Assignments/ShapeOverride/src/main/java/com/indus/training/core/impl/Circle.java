package com.indus.training.core.impl;

import com.indus.training.core.svc.Shape;

public class Circle extends Shape {
    @Override
    public String calculateProperties(double radius) {
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;
        return "Circle Dimension: " + radius + ", Area: " + area + ", Perimeter: " + perimeter;
    }
}
