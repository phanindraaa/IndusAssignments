package com.indus.training.core.impl;

import com.indus.training.core.svc.Transport;

public class Train extends Transport {
    @Override
    public String getDetails(String model, int capacity) {
        return "Train -> Model: " + model + ", Capacity: " + capacity;
    }
}
