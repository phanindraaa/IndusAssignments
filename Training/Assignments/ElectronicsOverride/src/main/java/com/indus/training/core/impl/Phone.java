package com.indus.training.core.impl;

import com.indus.training.core.svc.Electronics;

public class Phone extends Electronics {
    @Override
    public String getDetails(String brand, double price) {
        return "Phone -> Brand: " + brand + ", Price: " + price;
    }
}
