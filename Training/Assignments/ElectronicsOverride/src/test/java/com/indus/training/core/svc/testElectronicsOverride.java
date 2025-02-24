package com.indus.training.core.svc;

import junit.framework.TestCase;
import com.indus.training.core.impl.Phone;
import com.indus.training.core.impl.Laptop;

public class testElectronicsOverride extends TestCase {
    
    private Electronics phone;
    private Electronics laptop;

    protected void setUp() throws Exception {
        phone = new Phone();
        laptop = new Laptop();
    }

    protected void tearDown() throws Exception {
        phone = null;
        laptop = null;
    }

    public void testPhoneDetailsScenario() {
        // 1) Input
        String brand = "Apple";
        double price = 999.99;

        // 2) Expected Output
        String expOutput = "Phone -> Brand: " + brand + ", Price: " + price;

        // 3) Actual Output
        String actOutput = phone.getDetails(brand, price);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }

    public void testLaptopDetailsScenario() {
        // 1) Input
        String brand = "Dell";
        double price = 1199.99;

        // 2) Expected Output
        String expOutput = "Laptop -> Brand: " + brand + ", Price: " + price;

        // 3) Actual Output
        String actOutput = laptop.getDetails(brand, price);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }
}
