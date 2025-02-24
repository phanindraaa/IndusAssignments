package com.indus.training.core.svc;

// Interface for Bicycle operations.
public interface Bicycle {

	// Sets the gear of the bicycle.
	void setGear(int newGear);

	// Applies the brakes to decrease speed.
	void applyBrakes(int decrement);

	// Increases the speed of the bicycle.
	void speedUp(int increment);

	// Gets the current state of the bicycle.
	String getCurrentState();
}
