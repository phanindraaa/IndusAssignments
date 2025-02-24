package com.indus.training.core.svc;

import junit.framework.TestCase;
import com.indus.training.core.impl.Circle;
import com.indus.training.core.impl.Square;

public class testShapeOverride extends TestCase {
    
    private Shape circle;
    private Shape square;

    protected void setUp() throws Exception {
        circle = new Circle();
        square = new Square();
    }

    protected void tearDown() throws Exception {
        circle = null;
        square = null;
    }

    public void testCirclePropertiesScenario() {
        // 1) Input
        double radius = 5.0;

        // 2) Expected Output
        double area = Math.PI * radius * radius;
        double perimeter = 2 * Math.PI * radius;
        String expOutput = "Circle Dimension: " + radius + ", Area: " + area + ", Perimeter: " + perimeter;

        // 3) Actual Output
        String actOutput = circle.calculateProperties(radius);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }

    public void testSquarePropertiesScenario() {
        // 1) Input
        double side = 4.0;

        // 2) Expected Output
        double area = side * side;
        double perimeter = 4 * side;
        String expOutput = "Square Dimension: " + side + ", Area: " + area + ", Perimeter: " + perimeter;

        // 3) Actual Output
        String actOutput = square.calculateProperties(side);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }
}
