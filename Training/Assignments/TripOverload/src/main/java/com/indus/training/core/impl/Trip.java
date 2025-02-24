package com.indus.training.core.impl;

public class Trip {
    public String getDetails(String destination) {
        return "Trip to " + destination;
    }

    public String getDetails(String destination, double duration) {
        return "Trip to " + destination + " for " + duration + " days";
    }

    public String getDetails(String destination, double duration, String travelMode) {
        return "Trip to " + destination + " for " + duration + " days by " + travelMode;
    }
}
