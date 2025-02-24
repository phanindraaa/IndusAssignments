package com.indus.training.core.impl;

import com.indus.training.core.svc.Vehicle;

public class Car extends Vehicle{
	@Override
	public String Drive(int speed, double fuelTank, boolean isAutomatic) {
        return "Car Speed: " + speed + 
        		", fuelLevel: " + fuelTank + 
        		", Automatic: " + isAutomatic;
    }
}
