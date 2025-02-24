package com.indus.training.core.impl;

import com.indus.training.core.svc.Transport;

public class Bus extends Transport {
    @Override
    public String getDetails(String model, int capacity) {
        return "Bus -> Model: " + model + ", Capacity: " + capacity;
    }
}
