package com.indus.training.core.svc;

import com.indus.training.core.domain.DistanceConvInp;
import com.indus.training.core.domain.DistanceConvOut;

public interface DistanceConvInterface {
	public DistanceConvOut ConvertKmtoM(DistanceConvInp DistanceConvInpObj);
	public DistanceConvOut ConvertMtoKm(DistanceConvInp DistanceConvInpObj);

}
