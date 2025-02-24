package com.indus.training.core.impl;

import com.indus.training.core.domain.MatrixThreeInp;
import com.indus.training.core.domain.MatrixThreeOut;
import com.indus.training.core.svc.MatrixThreeInterface;

public class MatrixThreeOps implements MatrixThreeInterface {

	@Override
	public MatrixThreeOut MatrixAddition(MatrixThreeInp MatrixThreeInpObj) {
		// TODO Auto-generated method stub
		MatrixThreeOut MatrixTwoOutObj = new MatrixThreeOut();
		int[][] Matrix1 = MatrixThreeInpObj.Matrix1;
		int[][] Matrix2 = MatrixThreeInpObj.Matrix2;
		int[][] result = new int[3][3];
		for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = Matrix1[i][j] + Matrix2[i][j];
            }
        }
		MatrixTwoOutObj.Matrix1 = Matrix1;
		MatrixTwoOutObj.Matrix2 = Matrix2;
		MatrixTwoOutObj.Result = result;
		 
		 return MatrixTwoOutObj;
	}

	@Override
	public MatrixThreeOut MatrixMultiplication(MatrixThreeInp MatrixThreeInpObj) {
		// TODO Auto-generated method stub
		MatrixThreeOut MatrixTwoOutObj = new MatrixThreeOut();
		// TODO Auto-generated method stub
		int[][] Matrix1 = MatrixThreeInpObj.Matrix1;
		int[][] Matrix2 = MatrixThreeInpObj.Matrix2;
		int[][] result = new int[3][3];
		for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
					result[i][j] = 0;

	                for (int k = 0; k < 3; k++) {
	                    result[i][j] = result[i][j] + (Matrix1[i][k] * Matrix2[k][j]);
	                }
	            }
	        }
        MatrixTwoOutObj.Matrix1 = Matrix1;
		MatrixTwoOutObj.Matrix2 = Matrix2;
		MatrixTwoOutObj.Result = result;
        return MatrixTwoOutObj;
	}

}


