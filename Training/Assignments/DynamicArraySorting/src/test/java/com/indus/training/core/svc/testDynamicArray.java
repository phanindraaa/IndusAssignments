package com.indus.training.core.svc;

import java.util.Arrays;

import com.indus.training.core.impl.DynamicArray;

import junit.framework.TestCase;

public class testDynamicArray extends TestCase {
	
	private DynamicArray DynArray;
	protected void setUp() throws Exception {
		DynArray = new DynamicArray(3);
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		DynArray = null;
	}
	
	public void testDynAlloc() {
		
		//1) Input
		DynArray.dynamicAlloc(3.7);
		DynArray.dynamicAlloc(7.5);
		DynArray.dynamicAlloc(11.7);
		DynArray.dynamicAlloc(5.7);
		DynArray.dynamicAlloc(5.3);
		
		//2) expOutput
		double[] expArray = {3.7, 5.3, 5.7, 7.5, 11.7};
		String expectedArray = Arrays.toString(expArray);
		
		//3) Act Output
		DynArray.ArraySorting();
		String actArray = DynamicArray.getArray();
		
		//4) Assertions
		assertEquals(expectedArray, actArray);
		System.out.println("Unsorted Array"+ expectedArray);
		System.out.println("Sorted Array"+ actArray);
		
	}
	

}
