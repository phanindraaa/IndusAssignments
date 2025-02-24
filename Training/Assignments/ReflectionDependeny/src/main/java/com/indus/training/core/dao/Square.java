package com.indus.training.core.dao;

import com.indus.training.core.entity.ShapeInput;
import com.indus.training.core.entity.ShapeOutput;
import com.indus.training.core.exception.ShapeException;
import com.indus.training.core.svc.Shape;

public class Square implements Shape {
    private double side;

    public Square(ShapeInput shapeIn) throws ShapeException {
        if (shapeIn.getSide() <= 0) {
            throw new ShapeException("Invalid side value. Side must be greater than 0.");
        }
        this.side = shapeIn.getSide();
    }

    @Override
    public ShapeOutput calculateArea() {
        double result = side * side;
        ShapeOutput shapeOut = new ShapeOutput();
        shapeOut.setSide(side);
        shapeOut.setResult(result);
        return shapeOut;
    }
}

