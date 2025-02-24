package com.indus.training.core.domain;

import org.apache.log4j.LogManager;


public class CalcEncInp {

	private double param1;
	private double param2;
    private static final org.apache.log4j.Logger logger = LogManager.getLogger(CalcEncInp.class);

	
	public void setPraam1(double d) {
		logger.info("This is param1 "+ Double.toString(d));
		param1 = d;
	}
	
	public double getParam1() {
		return param1;
	}
	
	public void setPraam2(double d) {
		logger.info("This is param2 "+ Double.toString(d));
		param2 = d;
	}
	
	public double getParam2() {
		return param2;
	}
}

