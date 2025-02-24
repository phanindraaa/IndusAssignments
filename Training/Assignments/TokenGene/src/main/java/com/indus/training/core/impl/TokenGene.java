package com.indus.training.core.impl;

import java.util.Arrays;

import com.indus.training.core.svc.ITokenGen;

public class TokenGene implements ITokenGen {

	static int[] FinalArray;
//    public static final intCapacity = 100;
	public int Remaining;
	int Count = 0;
	public int InitialSize;

	// Constructor to initialize the array with the specified initial size
	public TokenGene(int InitialSize) {
		FinalArray = new int[InitialSize];
		this.InitialSize = InitialSize;
		this.Remaining = InitialSize;
	}

	// Method to dynamically allocate space in the array and add new tokens
	@Override
	public void dynamicAlloc(int number) throws ArrayIndexOutOfBoundsException {
		try {
			// Check if the array needs resizing
			if (number > Remaining) {
				// Resize the array and copy existing elements
				int[] newArr = new int[Count + number];
				System.arraycopy(FinalArray, 0, newArr, 0, FinalArray.length);
				FinalArray = newArr;
				Remaining = number;
			}

			// Generate and add new tokens to the array
			for (int i = 0; i < number; i++) {
				FinalArray[Count] = Count + 1; // Assigning sequential tokens
				Count++;
			}
			Remaining -= number; // Update remaining space

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array out of bounds.");
		}
	}

	// Method to return the array as a string
	@Override
	public String getArray() {
		return Arrays.toString(FinalArray);
	}

	// Method to get the current size of the array
	@Override
	public int getArraySize() {
		return FinalArray.length;
	}

	// Method to get element at particular index
	@Override
	public void getNumAt(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index >= FinalArray.length) {
			throw new ArrayIndexOutOfBoundsException("Index " + index + " is out of bounds.");
		} else {
			System.out.println("Element at the index " + index + " is: " + FinalArray[index]);
		}
	}

}
