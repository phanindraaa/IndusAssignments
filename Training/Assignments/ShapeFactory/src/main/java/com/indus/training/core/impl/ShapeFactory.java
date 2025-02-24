package com.indus.training.core.impl;

import com.indus.training.core.exception.ShapeNotFoundException;
import com.indus.training.core.svc.Shape;

//ShapeFactory.java
import java.lang.reflect.Constructor;

public class ShapeFactory {

 public static Shape createShape(String shapeType) throws ShapeNotFoundException {
     try {
         String className = shapeType;
         String packageName = "com.indus.training.core.entity.";
         Class<?> shapeClass = Class.forName(packageName+className);
         Constructor<?> constructor = shapeClass.getConstructor();
         return (Shape) constructor.newInstance();
     } catch (ClassNotFoundException e) {
         throw new ShapeNotFoundException("Shape not found: " + shapeType);
     } catch (Exception e) {
         throw new IllegalArgumentException("Error creating shape: " + e.getMessage());
     }
 }
}
