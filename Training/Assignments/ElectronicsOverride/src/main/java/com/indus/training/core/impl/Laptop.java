package com.indus.training.core.impl;

import com.indus.training.core.svc.Electronics;

public class Laptop extends Electronics {
    @Override
    public String getDetails(String brand, double price) {
        return "Laptop -> Brand: " + brand + ", Price: " + price;
    }
}
