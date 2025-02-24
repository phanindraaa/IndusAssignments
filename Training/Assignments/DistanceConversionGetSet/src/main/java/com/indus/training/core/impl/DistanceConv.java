package com.indus.training.core.impl;

import com.indus.training.core.domain.DistanceConvInp;
import com.indus.training.core.domain.DistanceConvOut;
import com.indus.training.core.svc.DistanceConvInterface;

public class DistanceConv implements DistanceConvInterface {

	@Override
	public DistanceConvOut ConvertKmtoM(DistanceConvInp DistanceConvInpObj) {
		// TODO Auto-generated method stub
		DistanceConvOut DistanceConvOutObj = new DistanceConvOut();
		double KiloMeters = DistanceConvInpObj.getKilometers();
		double Meteres = KiloMeters * 1000;
		DistanceConvOutObj.setConvType("KmToM");
		DistanceConvOutObj.setKilometers(KiloMeters);
		DistanceConvOutObj.setMeters(Meteres);
		return DistanceConvOutObj;
	}

	@Override
	public DistanceConvOut ConvertMtoKm(DistanceConvInp DistanceConvInpObj) {
		// TODO Auto-generated method stub
		DistanceConvOut DistanceConvOutObj = new DistanceConvOut();
		double Meters = DistanceConvInpObj.getMeters();
		double KiloMeteres = Meters / 1000;
		DistanceConvOutObj.setConvType("MToKm");
		DistanceConvOutObj.setKilometers(KiloMeteres);
		DistanceConvOutObj.setMeters(Meters);
		return DistanceConvOutObj;
	}

}
