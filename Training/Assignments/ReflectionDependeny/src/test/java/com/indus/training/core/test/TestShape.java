package com.indus.training.core.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.indus.training.core.entity.ShapeInput;
import com.indus.training.core.entity.ShapeOutput;
import com.indus.training.core.exception.ShapeException;
import com.indus.training.core.svc.Shape;

public class TestShape {

    private Shape shapeCalc;
    private Constructor<?> shapeCons;

    @Before
    public void setUp() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("PathsFile.txt"));
        String line = reader.readLine();
        String path = line.split("=")[1];
        Class<?> shapeClass = Class.forName(path);
        shapeCons = shapeClass.getConstructor(ShapeInput.class);
    }

    @After
    public void tearDown() throws Exception {
        shapeCalc = null;
    }

    // Test case for a valid square with positive side
    @Test
    public void testSquareValid() {
        ShapeInput shInp = new ShapeInput();
        shInp.setSide(2.0);
        try {
            shapeCalc = (Shape) shapeCons.newInstance(shInp);
            ShapeOutput outRes = shapeCalc.calculateArea();
            assertEquals(4.0, outRes.getResult(), 0.0001);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            fail("Unexpected exception: " + e.getMessage());
       
        }
    }

    // Test case for square with negative side value (should throw ShapeException)
    @Test
    public void testSquareInvalidSide() {
        ShapeInput shInp = new ShapeInput();
        shInp.setSide(-1.0);  // Invalid input
        try {
            shapeCalc = (Shape) shapeCons.newInstance(shInp);
            fail("Expected ShapeException was not thrown");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            Throwable cause = e.getCause();
            assertTrue(cause instanceof ShapeException);
            assertEquals("Invalid side value. Side must be greater than 0.", cause.getMessage());
      
        }
    }

    // Test case for circle with negative radius value (should throw ShapeException)
    @Test
    public void testCircleInvalidRadius() {
        ShapeInput shInp = new ShapeInput();
        shInp.setRadius(-1.0);  // Invalid input
        try {
            shapeCalc = (Shape) shapeCons.newInstance(shInp);
            fail("Expected ShapeException was not thrown");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            Throwable cause = e.getCause();
            assertTrue(cause instanceof ShapeException);
//            assertEquals("Invalid radius value. Radius must be greater than 0.", cause.getMessage());
       
    }
    }
}
