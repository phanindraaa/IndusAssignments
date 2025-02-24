package com.indus.training.spring.config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.indus.training.spring.impl.CalcImpl;

import org.springframework.context.ApplicationContext;
//import com.indus.training.spring.config.CalcConfig;

public class CalcApplication {
	
	public CalcImpl getCalcInstance() {
		ApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(CalcConfig.class);
			CalcImpl calc = context.getBean(CalcImpl.class);
			return calc;
		} finally {
			// TODO: handle finally clause
			 ((AnnotationConfigApplicationContext) context).close();
		}
		
	}
	
}
