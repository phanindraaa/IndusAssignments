package com.indus.training.core.svc;
import junit.framework.TestCase;
import com.indus.training.core.svc.Vehicle;
import com.indus.training.core.impl.Car;
import com.indus.training.core.impl.Bike;


public class testVehicleOverride extends TestCase {
	
	private Vehicle Car;
	private Vehicle Bike;
	protected void setUp() throws Exception {
		Car = new Car();
		Bike = new Bike();
	}

	protected void tearDown() throws Exception {
		Car = null;
		Bike = null;
	}
	
	public void testVehicleCarScenario1() {
		
		//1) Input
		int CarSpeed = 100;
		double FuelTank = 15;
		boolean isAuto = false;
		
		//2) Expected Output
		String expOutput = "Car Speed: 100, fuelLevel: 15.0, Automatic: false";
		
		//3) Actual Output
		String actOutput = Car.Drive(CarSpeed, FuelTank, isAuto);
		
		//4) Assertions
		assertEquals(expOutput, actOutput);
		
	}
	
	public void testVehicleCScenario1() {
		
		//1) Input
		int BikeSpeed = 100;
		double FuelTank = 15;
		boolean isAuto = false;
		
		//2) Expected Output
		String expOutput = "Bike Speed: 100, fuelLevel: 15.0, Automatic: false";
		
		//3) Actual Output
		String actOutput = Bike.Drive(BikeSpeed, FuelTank, isAuto);
		
		//4) Assertions
		assertEquals(expOutput, actOutput);
		
	}

}
