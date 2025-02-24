package com.indus.training.core.svc;

import com.indus.training.core.domain.BMIInput;
import com.indus.training.core.impl.BMIStreamBuffer;

import junit.framework.TestCase;

public class testBMIStreamBytes extends TestCase {
	
	private BMIStreamBuffer BMIStreamObj; 
	protected void setUp() throws Exception {
		super.setUp();
		BMIStreamObj = new BMIStreamBuffer();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		BMIStreamObj = null;
	}
	
	public void testBMIStreamBuffer() {
		BMIInput BMIInpObj = new BMIInput();
		BMIInpObj.setFilePath("src/java/resources");
		BMIInpObj.setFileName("");
	}

}
