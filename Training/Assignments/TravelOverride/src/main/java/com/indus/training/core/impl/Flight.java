package com.indus.training.core.impl;

import com.indus.training.core.svc.Tour;
import com.indus.training.core.svc.Bookable;

public class Flight implements Tour, Bookable {
    @Override
    public String getDetails(String destination, double duration) {
        return "Flight Destination: " + destination + ", Duration: " + duration + " hours";
    }

    @Override
    public String book() {
        return "Booking flight";
    }
}
