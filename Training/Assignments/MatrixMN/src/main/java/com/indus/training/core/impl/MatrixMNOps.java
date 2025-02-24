package com.indus.training.core.impl;

import com.indus.training.core.domain.MatrixMNInp;
import com.indus.training.core.domain.MatrixMNOut;
import com.indus.training.core.svc.MatrixMNInterface;

public class MatrixMNOps implements MatrixMNInterface {

	@Override
	public MatrixMNOut MatrixAddition(MatrixMNInp MatrixMNInpObj) {
		
		MatrixMNOut MatrixMNOutObj = new MatrixMNOut();
		int[][] Matrix1 = MatrixMNInpObj.Matrix1;
		int[][] Matrix2 = MatrixMNInpObj.Matrix2;
		int m = Matrix1.length;
        int p = Matrix1[0].length;
        int n = Matrix2[0].length;
		int[][] Result = new int[m][n];
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Result[i][j] = Matrix1[i][j] + Matrix2[i][j];
            }
        }
		MatrixMNOutObj.Matrix1 = Matrix1;
		MatrixMNOutObj.Matrix2 = Matrix2;
		MatrixMNOutObj.Result = Result;
		return MatrixMNOutObj;
	}

	@Override
	public MatrixMNOut MatrixMultiplication(MatrixMNInp MatrixMNInpObj) {
		MatrixMNOut MatrixMNOutObj = new MatrixMNOut();
		int[][] Matrix1 = MatrixMNInpObj.Matrix1;
		int[][] Matrix2 = MatrixMNInpObj.Matrix2;
		int m = Matrix1.length;
        int p = Matrix1[0].length;
        int n = Matrix2[0].length;
		int[][] Result = new int[m][n];
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Result[i][j] = 0;
                for (int k = 0; k < p; k++) {
                    Result[i][j] = Result[i][j] + (Matrix1[i][k] * Matrix2[k][j]);
                }
            }
        }
		MatrixMNOutObj.Matrix1 = Matrix1;
		MatrixMNOutObj.Matrix2 = Matrix2;
		MatrixMNOutObj.Result = Result;
		return MatrixMNOutObj;
	}

}
