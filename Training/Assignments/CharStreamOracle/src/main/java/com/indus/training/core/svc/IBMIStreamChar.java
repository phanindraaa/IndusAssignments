package com.indus.training.core.svc;

import java.io.IOException;

import com.indus.training.core.domain.BMIInput;
import com.indus.training.core.domain.BMIOutput;

public interface IBMIStreamChar {
	public void BMIStream(BMIInput BMIInpObj, BMIOutput BMIOutObj) throws IOException;

}
