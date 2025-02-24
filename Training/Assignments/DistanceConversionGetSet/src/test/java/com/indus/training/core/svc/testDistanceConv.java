package com.indus.training.core.svc;

import com.indus.training.core.domain.DistanceConvInp;
import com.indus.training.core.domain.DistanceConvOut;
import com.indus.training.core.impl.DistanceConv;

import junit.framework.TestCase;

public class testDistanceConv extends TestCase {
	
	private DistanceConv DistanceConvObj;
	protected void setUp() throws Exception {
		DistanceConvObj = new DistanceConv();
	}

	protected void tearDown() throws Exception {
		DistanceConvObj = null;
	}
	
	public void testKmToMConvScenario1() {
		
		//1) Input
		DistanceConvInp DistanceConvInpObj = new DistanceConvInp();
		DistanceConvInpObj.setKilometers(1000);
		
		//2) Expected Output
		DistanceConvOut expDistanceConvOutObj = new DistanceConvOut();
		expDistanceConvOutObj.setKilometers(1000);
		expDistanceConvOutObj.setConvType("KmToM");
		expDistanceConvOutObj.setMeters(1000000);
		
		//3) Actual Output
		DistanceConvOut actDistanceConvOutObj = DistanceConvObj.ConvertKmtoM(DistanceConvInpObj);
		
		//4) Assertions
		assertEquals(expDistanceConvOutObj.getKilometers(), actDistanceConvOutObj.getKilometers());
		assertEquals(expDistanceConvOutObj.getMeters(), actDistanceConvOutObj.getMeters());
		assertEquals(expDistanceConvOutObj.getConvType(), actDistanceConvOutObj.getConvType());
		
	}
	
	public void testMToKmConvScenario1() {
		
		//1) Input
		DistanceConvInp DistanceConvInpObj = new DistanceConvInp();
		DistanceConvInpObj.setMeters(1000);
		
		//2) Expected Output
		DistanceConvOut expDistanceConvOutObj = new DistanceConvOut();
		expDistanceConvOutObj.setMeters(1000);
		expDistanceConvOutObj.setConvType("MToKm");
		expDistanceConvOutObj.setKilometers(1);
		
		//3) Actual Output
		DistanceConvOut actDistanceConvOutObj = DistanceConvObj.ConvertMtoKm(DistanceConvInpObj);
		
		//4) Assertions
		assertEquals(expDistanceConvOutObj.getKilometers(), actDistanceConvOutObj.getKilometers());
		assertEquals(expDistanceConvOutObj.getMeters(), actDistanceConvOutObj.getMeters());
		assertEquals(expDistanceConvOutObj.getConvType(), actDistanceConvOutObj.getConvType());
		
	}

}
