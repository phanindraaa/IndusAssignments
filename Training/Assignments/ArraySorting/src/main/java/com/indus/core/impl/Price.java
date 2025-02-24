package com.indus.training.core.impl;

import com.indus.training.core.domain.PriceInput;
import com.indus.training.core.domain.PriceOutput;
import com.indus.training.core.excp.ArraySizeException;
import com.indus.training.core.svc.IPrice;

public class Price implements IPrice {

	@Override
	public PriceOutput sortArray(PriceInput priceInObj) throws ArraySizeException {
		PriceOutput priceOutObj = null;
		double[] arry = priceInObj.getArr();
		int n = priceInObj.getSize();
		int p = arry.length;
		if (n != p) {
			throw new ArraySizeException(
					"There is a mismatch between the given array input size and the length of the input array.");
		} else {
			double[] arrySorted = new double[n];
			long startTime = System.nanoTime();
			for (int i = 0; i < n; i++) {
				double a = arry[i];
				int count = 0;
				for (int j = 0; j < n; j++) {
					if (a > arry[j]) {
						count += 1;
					}
				}
				arrySorted[count] = a;
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			priceOutObj = new PriceOutput();
			priceOutObj.setTimeTakenForSorting(duration);
			priceOutObj.setArrActual(arry);
			priceOutObj.setArrSorted(arrySorted);

			return priceOutObj;
		}

	}

}
