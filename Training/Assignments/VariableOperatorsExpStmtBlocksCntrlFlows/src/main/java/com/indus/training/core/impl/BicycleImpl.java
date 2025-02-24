package com.indus.training.core.impl;

import com.indus.training.core.svc.Bicycle;

// Implementation of the Bicycle interface.
public class BicycleImpl implements Bicycle {
    private int speed = 0;
    private int gear = 1;

    // Sets the gear of the bicycle.
    public void setGear(int newGear) {
    	gear = newGear;
    }
    // Applies the brakes to decrease speed.
    public void applyBrakes(int decrement) {
        if (speed - decrement >= 0) {
            speed -= decrement;
        } else {
            speed = 0; // Speed cannot go below 0
        }
    }

    // Increases the speed of the bicycle.
    public void speedUp(int increment) {
        speed += increment;
    }

    // Gets the current state of the bicycle.
    public String getCurrentState() {
        return "Speed: " + speed + ", Gear: " + gear;
    }

    // Resets the bicycle's state to default values.
    public void reset() {
        speed = 0;
        gear = 1;
    }

    // Applies gradual brakes until speed is zero.
    public void gradualBrakes() {
        while (speed > 0) {
            applyBrakes(1);
        }
    }

    // Simulates pedaling the bicycle until a certain speed is reached.
    public void pedalToSpeed(int targetSpeed) {
        while (speed < targetSpeed) {
            speedUp(1);
        }
    }
}
