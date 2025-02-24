package com.indus.training.core.impl;

import com.indus.training.core.domain.MatrixTwoInp;
import com.indus.training.core.domain.MatrixTwoOut;
import com.indus.training.core.svc.MatrixTwoInterface;

public class MatrixOps implements MatrixTwoInterface {

	@Override
	public MatrixTwoOut MatrixAddition (MatrixTwoInp MatrixTwoInpObj) {
		MatrixTwoOut MatrixTwoOutObj = new MatrixTwoOut();
		// TODO Auto-generated method stub
		int[][] Matrix1 = MatrixTwoInpObj.Matrix1;
		int[][] Matrix2 = MatrixTwoInpObj.Matrix2;
		int[][] result = new int[2][2];
		result[0][0] = Matrix1[0][0] + Matrix2[0][0];
        result[0][1] = Matrix1[0][1] + Matrix2[0][1];
        result[1][0] = Matrix1[1][0] + Matrix2[1][0];
        result[1][1] = Matrix1[1][1] + Matrix2[1][1];
		MatrixTwoOutObj.Matrix1 = Matrix1;
		MatrixTwoOutObj.Matrix2 = Matrix2;
		MatrixTwoOutObj.Result = result;
		 
		 return MatrixTwoOutObj;
	}

	@Override
	public MatrixTwoOut MatrixMultiplication(MatrixTwoInp MatrixTwoInpObj) {
		MatrixTwoOut MatrixTwoOutObj = new MatrixTwoOut();
		// TODO Auto-generated method stub
		int[][] Matrix1 = MatrixTwoInpObj.Matrix1;
		int[][] Matrix2 = MatrixTwoInpObj.Matrix2;
		int[][] result = new int[2][2];
		result[0][0] = Matrix1[0][0] * Matrix2[0][0] + Matrix1[0][1] * Matrix2[1][0];
        result[0][1] = Matrix1[0][0] * Matrix2[0][1] + Matrix1[0][1] * Matrix2[1][1];
        result[1][0] = Matrix1[1][0] * Matrix2[0][0] + Matrix1[1][1] * Matrix2[1][0];
        result[1][1] = Matrix1[1][0] * Matrix2[0][1] + Matrix1[1][1] * Matrix2[1][1];
        MatrixTwoOutObj.Matrix1 = Matrix1;
		MatrixTwoOutObj.Matrix2 = Matrix2;
		MatrixTwoOutObj.Result = result;
        return MatrixTwoOutObj;
	}

}
