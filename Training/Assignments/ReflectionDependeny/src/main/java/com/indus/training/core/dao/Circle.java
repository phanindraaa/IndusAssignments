package com.indus.training.core.dao;

import com.indus.training.core.entity.ShapeInput;
import com.indus.training.core.entity.ShapeOutput;
import com.indus.training.core.exception.ShapeException;
import com.indus.training.core.svc.Shape;

public class Circle implements Shape {
    private double radius;

    public Circle(ShapeInput shapeIn) throws ShapeException {
        if (shapeIn.getRadius() <= 0) {
            throw new ShapeException("Invalid radius value. Radius must be greater than 0.");
        }
        this.radius = shapeIn.getRadius();
    }

    @Override
    public ShapeOutput calculateArea() {
        double result = Math.PI * radius * radius;
        ShapeOutput shapeOut = new ShapeOutput();
        shapeOut.setRadius(radius);
        shapeOut.setResult(result);
        return shapeOut;
    }
}

