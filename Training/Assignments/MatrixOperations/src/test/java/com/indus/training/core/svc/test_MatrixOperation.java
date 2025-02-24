package com.indus.training.core.svc;

import static org.junit.Assert.assertArrayEquals;

import com.indus.training.core.domain.MatrixTwoInp;
import com.indus.training.core.domain.MatrixTwoOut;
import com.indus.training.core.impl.MatrixOps;

import junit.framework.TestCase;

public class test_MatrixOperation extends TestCase {

	private MatrixOps MatrixOperationObj;

	protected void setUp() throws Exception {
		MatrixOperationObj = new MatrixOps();
	}

	protected void tearDown() throws Exception {
		MatrixOperationObj = null;
	}

	@SuppressWarnings("restriction")
	public void testMatrixAdditionScenario1() {

		// 1) Input
		MatrixTwoInp MatrixTwoInpObj = new MatrixTwoInp();
		int[][] Matrix1 = { { 1, 2 }, { 3, 4 } };
		MatrixTwoInpObj.Matrix1 = Matrix1;

		int[][] Matrix2 = { { 5, 6 }, { 7, 8 } };
		MatrixTwoInpObj.Matrix2 = Matrix2;

		// 2) Expected Output
		MatrixTwoOut expMatrixTwoOutObj = new MatrixTwoOut();
		expMatrixTwoOutObj.Matrix1 = Matrix1;
		expMatrixTwoOutObj.Matrix2 = Matrix2;
		int[][] Result = { { 6, 8 }, { 10, 12 } };
		expMatrixTwoOutObj.Result = Result;

		// 3) Actual Output
		MatrixTwoOut actMatrixTwoOutObj = MatrixOperationObj.MatrixAddition(MatrixTwoInpObj);

		// 4) Assertions
		assertArrayEquals(expMatrixTwoOutObj.Matrix1, actMatrixTwoOutObj.Matrix1);
		assertArrayEquals(expMatrixTwoOutObj.Matrix2, actMatrixTwoOutObj.Matrix2);
		assertArrayEquals(expMatrixTwoOutObj.Result, actMatrixTwoOutObj.Result);
	}
	
	public void testMatrixMultiplicationScenario1() {

		// 1) Input
		MatrixTwoInp MatrixTwoInpObj = new MatrixTwoInp();
		int[][] Matrix1 = { { 1, 2 }, { 3, 4 } };
		MatrixTwoInpObj.Matrix1 = Matrix1;

		int[][] Matrix2 = { { 5, 6 }, { 7, 8 } };
		MatrixTwoInpObj.Matrix2 = Matrix2;

		// 2) Expected Output
		MatrixTwoOut expMatrixTwoOutObj = new MatrixTwoOut();
		expMatrixTwoOutObj.Matrix1 = Matrix1;
		expMatrixTwoOutObj.Matrix2 = Matrix2;
		int[][] Result = { { 19, 22 }, { 43, 50 } };
		expMatrixTwoOutObj.Result = Result;

		// 3) Actual Output
		MatrixTwoOut actMatrixTwoOutObj = MatrixOperationObj.MatrixMultiplication(MatrixTwoInpObj);

		// 4) Assertions
		assertArrayEquals(expMatrixTwoOutObj.Matrix1, actMatrixTwoOutObj.Matrix1);
		assertArrayEquals(expMatrixTwoOutObj.Matrix2, actMatrixTwoOutObj.Matrix2);
		assertArrayEquals(expMatrixTwoOutObj.Result, actMatrixTwoOutObj.Result);
	}
}
