package com.indus.training.core.svc;

public class Vehicle {
    public String Drive(int speed, double fuelTank, boolean isAutomatic) {
        return "Speed: " + speed + 
        		", fuelLevel: " + fuelTank + 
        		", Automatic: " + isAutomatic;
    }
}

