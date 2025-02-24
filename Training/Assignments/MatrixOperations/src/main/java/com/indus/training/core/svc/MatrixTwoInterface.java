package com.indus.training.core.svc;

import com.indus.training.core.domain.MatrixTwoInp;
import com.indus.training.core.domain.MatrixTwoOut;

public interface MatrixTwoInterface {
	
	public MatrixTwoOut MatrixAddition (MatrixTwoInp MatrixTwoInpObj);
	public MatrixTwoOut MatrixMultiplication (MatrixTwoInp MatrixTwoInpObj);
}
