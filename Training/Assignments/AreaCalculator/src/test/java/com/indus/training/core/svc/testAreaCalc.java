package com.indus.training.core.svc;

import com.indus.training.core.domain.AreaCalcInput;
import com.indus.training.core.domain.AreaCalcOutput;
import com.indus.training.core.impl.AreaCalc;

import junit.framework.TestCase;

public class testAreaCalc extends TestCase {
	
	private AreaCalc AreaCalcObj;
	protected void setUp() throws Exception {
		AreaCalcObj = new AreaCalc();
	}

	protected void tearDown() throws Exception {
		AreaCalcObj = null;
	}
	
	public void testTriangleAreaScenario1() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.base = 3.0;
		AreaCalcInpObj.height = 7.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.base = 3.0;
		expAreaCalcOutObj.height = 7.0;
		expAreaCalcOutObj.Area = 10.5;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateTriangleArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.base, actAreaCalcOutObj.base);
		assertEquals(expAreaCalcOutObj.height, actAreaCalcOutObj.height);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
	
	public void testTriangleAreaScenario2() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.base = 5.0;
		AreaCalcInpObj.height = 3.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.base = 5.0;
		expAreaCalcOutObj.height = 3.0;
		expAreaCalcOutObj.Area = 7.5;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateTriangleArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.base, actAreaCalcOutObj.base);
		assertEquals(expAreaCalcOutObj.height, actAreaCalcOutObj.height);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
	
	public void testTriangleAreaScenario3() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.base = 1.0;
		AreaCalcInpObj.height = 1.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.base = 1.0;
		expAreaCalcOutObj.height = 1.0;
		expAreaCalcOutObj.Area = 0.5;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateTriangleArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.base, actAreaCalcOutObj.base);
		assertEquals(expAreaCalcOutObj.height, actAreaCalcOutObj.height);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
	
	public void testCircleAreaScenario1() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.radius = 7.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.radius = 7.0;
		expAreaCalcOutObj.Area = 154.0;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateCircleArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.radius, actAreaCalcOutObj.radius);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
	
	public void testCircleAreaScenario2() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.radius = 1.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.radius = 1.0;
		expAreaCalcOutObj.Area = 3.0;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateCircleArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.radius, actAreaCalcOutObj.radius);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
	
	public void testCircleAreaScenario3() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.radius = 9.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.radius = 9.0;
		expAreaCalcOutObj.Area = 254.0;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateCircleArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.radius, actAreaCalcOutObj.radius);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
	
	public void testSquareAreaScenario1() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.side = 7.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.side = 7.0;
		expAreaCalcOutObj.Area = 49.0;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateSquareArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.side, actAreaCalcOutObj.side);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
	
	public void testSquareAreaScenario2() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.side = 0.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.side = 0.0;
		expAreaCalcOutObj.Area = 0.0;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateSquareArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.side, actAreaCalcOutObj.side);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}

	public void testSquareAreaScenario3() {
		
		//1) Input
		AreaCalcInput AreaCalcInpObj = new AreaCalcInput();
		AreaCalcInpObj.side = 10000.0;
		
		//2) Expected Output
		AreaCalcOutput expAreaCalcOutObj = new AreaCalcOutput();
		expAreaCalcOutObj.side = 10000.0;
		expAreaCalcOutObj.Area = 100000000.0;
		
		//3) Actual Output
		AreaCalcOutput actAreaCalcOutObj = AreaCalcObj.calculateSquareArea(AreaCalcInpObj);
		
		//4) Assertions
		assertEquals(expAreaCalcOutObj.side, actAreaCalcOutObj.side);
		assertEquals(expAreaCalcOutObj.Area, actAreaCalcOutObj.Area);
	}
}
