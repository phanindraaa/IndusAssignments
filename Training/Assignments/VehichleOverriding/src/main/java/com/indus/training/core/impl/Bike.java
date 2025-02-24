package com.indus.training.core.impl;

import com.indus.training.core.svc.Vehicle;

public class Bike extends Vehicle{
	@Override
	public String Drive(int speed, double fuelTank, boolean isAutomatic) {
        return "Bike Speed: " + speed + 
        		", fuelLevel: " + fuelTank + 
        		", Automatic: " + isAutomatic;
    }
}
