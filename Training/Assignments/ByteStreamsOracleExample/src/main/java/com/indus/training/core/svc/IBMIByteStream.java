package com.indus.training.core.svc;

import java.io.IOException;

import com.indus.training.core.domain.BodyIndexInput;
import com.indus.training.core.domain.BodyIndexOutput;

public interface IBMIByteStream {
	public BodyIndexOutput readWeightHeight(BodyIndexInput BMIInpObj) throws IOException;
}
