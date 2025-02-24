package com.indus.training.core.impl;

import com.indus.training.core.svc.IDynamicArray;
import java.util.Arrays;

public class DynamicArray implements IDynamicArray {

    static double[] FinalArray;
    int Count = 0;

    // Constructor to initialize the array with the specified initial size
    public DynamicArray(int InitialSize) {
        FinalArray = new double[InitialSize];
    }

    @Override
    public void dynamicAlloc(double Value) throws ArrayIndexOutOfBoundsException {
        // Check if the array is full
        if (Count == FinalArray.length) {
            // Create a new array with an increased size and copy elements
            double[] newArr = new double[FinalArray.length + 1];
            System.arraycopy(FinalArray, 0, newArr, 0, FinalArray.length);
            FinalArray = newArr;
        }
        // Add the new value to the array
        FinalArray[Count] = Value;
        Count = Count + 1;
    }

    @Override
    public void ArraySorting() {
        // Sort the array
        Arrays.sort(FinalArray);
    }

    public static String getArray() {
        return Arrays.toString(FinalArray);
    }
}
