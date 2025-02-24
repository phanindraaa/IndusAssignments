package com.indus.training.core.svc;

import com.indus.training.core.domain.MatrixMNInp;
import com.indus.training.core.domain.MatrixMNOut;

public interface MatrixMNInterface {
	public	MatrixMNOut MatrixAddition (MatrixMNInp MatrixMNInpObj);
	public MatrixMNOut MatrixMultiplication (MatrixMNInp MatrixMNInpObj);
}
