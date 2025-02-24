package com.indus.training.core.svc;

import static org.junit.Assert.assertArrayEquals;

import com.indus.training.core.domain.MatrixThreeInp;
import com.indus.training.core.domain.MatrixThreeOut;
import com.indus.training.core.impl.MatrixThreeOps;

import junit.framework.TestCase;

public class testMatrixThree extends TestCase {

	private MatrixThreeOps MatrixThreeOpsObj;

	protected void setUp() throws Exception {
		MatrixThreeOpsObj = new MatrixThreeOps();
	}

	protected void tearDown() throws Exception {
		MatrixThreeOpsObj = null;
	}

	@SuppressWarnings("restriction")
	public void testMatrixAdditionScenario1() {

		// 1) Input
		MatrixThreeInp MatrixThreeInpObj = new MatrixThreeInp();
		int[][] Matrix1 = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
		MatrixThreeInpObj.Matrix1 = Matrix1;

		int[][] Matrix2 = { { 5, 6, 7 }, { 7, 8, 9}, {10, 11, 12} };
		MatrixThreeInpObj.Matrix2 = Matrix2;

		// 2) Expected Output
		MatrixThreeOut expMatrixThreeOutObj = new MatrixThreeOut();
		expMatrixThreeOutObj.Matrix1 = Matrix1;
		expMatrixThreeOutObj.Matrix2 = Matrix2;
		int[][] Result = { { 6, 8, 10 }, { 10, 12, 14 }, {16, 18, 20} };
		expMatrixThreeOutObj.Result = Result;

		// 3) Actual Output
		MatrixThreeOut actMatrixThreeOutObj = MatrixThreeOpsObj.MatrixAddition(MatrixThreeInpObj);

		// 4) Assertions
		assertArrayEquals(expMatrixThreeOutObj.Matrix1, actMatrixThreeOutObj.Matrix1);
		assertArrayEquals(expMatrixThreeOutObj.Matrix2, actMatrixThreeOutObj.Matrix2);
		assertArrayEquals(expMatrixThreeOutObj.Result, actMatrixThreeOutObj.Result);
	}
	
	@SuppressWarnings("restriction")
	public void testMatrixMultiplicationScenario1() {

		// 1) Input
		MatrixThreeInp MatrixThreeInpObj = new MatrixThreeInp();
		int[][] Matrix1 = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
		MatrixThreeInpObj.Matrix1 = Matrix1;

		int[][] Matrix2 = { { 5, 6, 7 }, { 7, 8, 9}, {10, 11, 12} };
		MatrixThreeInpObj.Matrix2 = Matrix2;

		// 2) Expected Output
		MatrixThreeOut expMatrixThreeOutObj = new MatrixThreeOut();
		expMatrixThreeOutObj.Matrix1 = Matrix1;
		expMatrixThreeOutObj.Matrix2 = Matrix2;
		int[][] Result = { { 49, 55, 61 }, { 93, 105, 117 }, {159, 180, 201} };
		expMatrixThreeOutObj.Result = Result;

		// 3) Actual Output
		MatrixThreeOut actMatrixThreeOutObj = MatrixThreeOpsObj.MatrixMultiplication(MatrixThreeInpObj);

		// 4) Assertions
		assertArrayEquals(expMatrixThreeOutObj.Matrix1, actMatrixThreeOutObj.Matrix1);
		assertArrayEquals(expMatrixThreeOutObj.Matrix2, actMatrixThreeOutObj.Matrix2);
		assertArrayEquals(expMatrixThreeOutObj.Result, actMatrixThreeOutObj.Result);
	}
	
	
}
