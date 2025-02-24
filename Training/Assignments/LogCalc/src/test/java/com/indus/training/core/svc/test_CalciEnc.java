package com.indus.training.core.svc;

import com.indus.training.core.domain.CalcEncInp;
import com.indus.training.core.domain.CalcEncOut;

import junit.framework.TestCase;

public class test_CalciEnc extends TestCase {

	private CalculatorEncryption CalcEncrObj;

	protected void setUp() throws Exception {
//		CalcEncrObj = new CalcEncr();
		try {

			@SuppressWarnings("rawtypes")
			Class calciClsObj = Class.forName("com.indus.training.core.impl.CalcEncr");
			@SuppressWarnings("deprecation")
			Object calciObj = calciClsObj.newInstance();
			CalcEncrObj = (CalculatorEncryption) calciObj;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void tearDown() throws Exception {
		CalcEncrObj = null;
	}

	public void testAdditionScenario1() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(4.0);
		CalEncInpObj.setPraam2(3.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(4.0);
		expCalEncOutObj.setPraam2(3.0);
		expCalEncOutObj.setResult(7.0);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Addition(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testAdditionScenario2() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(7000000.0);
		CalEncInpObj.setPraam2(7000000.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(7000000.0);
		expCalEncOutObj.setPraam2(7000000.0);
		expCalEncOutObj.setResult(1.4E7);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Addition(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testAdditionScenario3() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(-25.0);
		CalEncInpObj.setPraam2(25.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(-25.0);
		expCalEncOutObj.setPraam2(25.0);
		expCalEncOutObj.setResult(0);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Addition(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testSubtractScenario1() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(-25.0);
		CalEncInpObj.setPraam2(25.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(-25.0);
		expCalEncOutObj.setPraam2(25.0);
		expCalEncOutObj.setResult(-50);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Subtract(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testSubtractScenario2() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(25.0);
		CalEncInpObj.setPraam2(25.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(25.0);
		expCalEncOutObj.setPraam2(25.0);
		expCalEncOutObj.setResult(0);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Subtract(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testMultiplyScenario1() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(-25.0);
		CalEncInpObj.setPraam2(25.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(-25.0);
		expCalEncOutObj.setPraam2(25.0);
		expCalEncOutObj.setResult(-625.0);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Multiply(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testMultiplyScenario2() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(-25.0);
		CalEncInpObj.setPraam2(0.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(-25.0);
		expCalEncOutObj.setPraam2(0.0);
		expCalEncOutObj.setResult(-0.0);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Multiply(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testDivisionScenario1() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(-25.0);
		CalEncInpObj.setPraam2(25.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(-25.0);
		expCalEncOutObj.setPraam2(25.0);
		expCalEncOutObj.setResult(-1.0);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Division(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

	public void testDivisionScenario2() {

		// 1) Input
		CalcEncInp CalEncInpObj = new CalcEncInp();
		CalEncInpObj.setPraam1(25.0);
		CalEncInpObj.setPraam2(5.0);

		// 2) Expected Output
		CalcEncOut expCalEncOutObj = new CalcEncOut();
		expCalEncOutObj.setPraam1(25.0);
		expCalEncOutObj.setPraam2(5.0);
		expCalEncOutObj.setResult(5.0);

		// 3) Actual Output
		CalcEncOut actCalEncOutObj = CalcEncrObj.Division(CalEncInpObj);

		// 4) Assertions
		assertEquals(expCalEncOutObj.getParam1(), actCalEncOutObj.getParam1());
		assertEquals(expCalEncOutObj.getParam2(), actCalEncOutObj.getParam2());
		assertEquals(expCalEncOutObj.getResult(), actCalEncOutObj.getResult());
	}

}
