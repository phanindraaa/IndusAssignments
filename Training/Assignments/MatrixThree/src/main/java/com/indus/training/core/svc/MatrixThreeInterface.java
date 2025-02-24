package com.indus.training.core.svc;

import com.indus.training.core.domain.MatrixThreeInp;
import com.indus.training.core.domain.MatrixThreeOut;

public interface MatrixThreeInterface {
	public	MatrixThreeOut MatrixAddition (MatrixThreeInp MatrixThreeInpObj);
	public MatrixThreeOut MatrixMultiplication (MatrixThreeInp MatrixThreeInpObj);
}
