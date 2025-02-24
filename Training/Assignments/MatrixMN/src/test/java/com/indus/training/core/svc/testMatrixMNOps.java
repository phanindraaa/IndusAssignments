package com.indus.training.core.svc;

import static org.junit.Assert.assertArrayEquals;

import com.indus.training.core.domain.MatrixMNInp;
import com.indus.training.core.domain.MatrixMNOut;
import com.indus.training.core.impl.MatrixMNOps;

import junit.framework.TestCase;

public class testMatrixMNOps extends TestCase {

	private MatrixMNOps MatrixMNOpsObj;
	protected void setUp() throws Exception {
		MatrixMNOpsObj = new MatrixMNOps();
	}

	protected void tearDown() throws Exception {
		MatrixMNOpsObj = null;
	}
	
	@SuppressWarnings("restriction")
	public void testMatrixMNMultiplicationScenario1() {
		
		MatrixMNInp MatrixThreeInpObj = new MatrixMNInp();
		int[][] Matrix1 = { { 1, 2, 3 }, { 3, 4, 5 } };
		MatrixThreeInpObj.Matrix1 = Matrix1;

		int[][] Matrix2 = { { 5, 6, 7}, { 7, 8, 9}, {10, 11, 12}};
		MatrixThreeInpObj.Matrix2 = Matrix2;

		// 2) Expected Output
		MatrixMNOut expMatrixThreeOutObj = new MatrixMNOut();
		expMatrixThreeOutObj.Matrix1 = Matrix1;
		expMatrixThreeOutObj.Matrix2 = Matrix2;
		int[][] Result = { { 49, 55, 61 }, { 93, 105, 117 } };
		expMatrixThreeOutObj.Result = Result;

		// 3) Actual Output
		MatrixMNOut actMatrixThreeOutObj = MatrixMNOpsObj.MatrixMultiplication(MatrixThreeInpObj);

		// 4) Assertions
		assertArrayEquals(expMatrixThreeOutObj.Matrix1, actMatrixThreeOutObj.Matrix1);
		assertArrayEquals(expMatrixThreeOutObj.Matrix2, actMatrixThreeOutObj.Matrix2);
		assertArrayEquals(expMatrixThreeOutObj.Result, actMatrixThreeOutObj.Result);
	}
	
	@SuppressWarnings("restriction")
	public void testMatrixAdditionScenario1() {
		MatrixMNInp MatrixThreeInpObj = new MatrixMNInp();
		int[][] Matrix1 = { { 1, 2, 3 }, { 3, 4, 5 } };
		MatrixThreeInpObj.Matrix1 = Matrix1;

		int[][] Matrix2 = { { 5, 6, 7}, { 7, 8, 9}};
		MatrixThreeInpObj.Matrix2 = Matrix2;

		// 2) Expected Output
		MatrixMNOut expMatrixThreeOutObj = new MatrixMNOut();
		expMatrixThreeOutObj.Matrix1 = Matrix1;
		expMatrixThreeOutObj.Matrix2 = Matrix2;
		int[][] Result = { { 6, 8, 10 }, { 10, 12, 14 } };
		expMatrixThreeOutObj.Result = Result;

		// 3) Actual Output
		MatrixMNOut actMatrixThreeOutObj = MatrixMNOpsObj.MatrixAddition(MatrixThreeInpObj);

		// 4) Assertions
		assertArrayEquals(expMatrixThreeOutObj.Matrix1, actMatrixThreeOutObj.Matrix1);
		assertArrayEquals(expMatrixThreeOutObj.Matrix2, actMatrixThreeOutObj.Matrix2);
		assertArrayEquals(expMatrixThreeOutObj.Result, actMatrixThreeOutObj.Result);
	}

}
