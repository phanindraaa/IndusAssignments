package com.indus.training.core.test;

import org.junit.Before;
import org.junit.Test;

import com.indus.training.core.entity.ShapeInput;
import com.indus.training.core.entity.ShapeOuput;
import com.indus.training.core.exception.ShapeNotFoundException;
import com.indus.training.core.impl.ShapeFactory;
import com.indus.training.core.impl.ShapeImpl;

import static org.junit.Assert.*;

public class testShape {

    private ShapeImpl shapeService;

    @Before
    public void setUp() {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeService = new ShapeImpl(shapeFactory);
    }

    @Test
    public void testRectangleArea() throws ShapeNotFoundException {
        ShapeInput input = new ShapeInput("Rectangle", 5, 3);
        ShapeOuput output = shapeService.getShapeArea(input);
        assertEquals(15.0, output.getArea(), 0.001);
        assertEquals("Rectangle", output.getShapeType());
    }

    @Test
    public void testCircleArea() throws ShapeNotFoundException {
        ShapeInput input = new ShapeInput("Circle", 4);
        ShapeOuput output = shapeService.getShapeArea(input);
        assertEquals(Math.PI * 16, output.getArea(), 0.001);
        assertEquals("Circle", output.getShapeType());
    }

    @Test
    public void testTriangleArea() throws ShapeNotFoundException {
        ShapeInput input = new ShapeInput("Triangle", 6, 2);
        ShapeOuput output = shapeService.getShapeArea(input);
        assertEquals(6.0, output.getArea(), 0.001);
        assertEquals("Triangle", output.getShapeType());
    }

    @Test(expected = ShapeNotFoundException.class)
    public void testShapeNotFoundException() throws ShapeNotFoundException {
        ShapeInput input = new ShapeInput("Pentagon", 5);
        shapeService.getShapeArea(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentExceptionForInvalidDimensions() throws ShapeNotFoundException {
        ShapeInput input = new ShapeInput("Circle", 4, 5);  // Circle only takes 1 dimension (radius)
        shapeService.getShapeArea(input);
    }
}
