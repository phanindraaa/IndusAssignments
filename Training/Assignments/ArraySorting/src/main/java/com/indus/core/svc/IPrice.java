package com.indus.training.core.svc;

import com.indus.training.core.domain.PriceInput;
import com.indus.training.core.domain.PriceOutput;
import com.indus.training.core.excp.ArraySizeException;

public interface IPrice {
	
	public PriceOutput sortArray(PriceInput priceInObj) throws ArraySizeException;

}
