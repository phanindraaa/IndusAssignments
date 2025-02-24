package com.indus.training.core.svc;

import com.indus.training.core.impl.WrapperNumbers;

import junit.framework.TestCase;

public class testWrapperNumber extends TestCase {

    // Test to verify the addition of Integer values
    public void testAddInteger() {
        WrapperNumbers wrapper = new WrapperNumbers(10, 20.5, null, null);
        wrapper.addInteger(5);
        Integer result = wrapper.getIntValue();
        boolean condition = (result.equals(15));
//        assertEquals(wrapper.getIntValue(),result);
//        assertEquals(wrapper.getIntValue(), 15);
        assertTrue(condition);
    }

    // Test to verify the addition of Double values
    public void testAddDouble() {
        WrapperNumbers wrapper = new WrapperNumbers(10, 20.5, null, null);
        wrapper.addDouble(4.5);
        Double result = wrapper.getDoubleValue();
        boolean condition = (result.equals(25.0));
        assertTrue(condition);
    }
}
