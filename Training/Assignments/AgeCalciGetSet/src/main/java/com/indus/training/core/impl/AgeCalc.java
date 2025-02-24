package com.indus.training.core.impl;

import java.time.LocalDate;
import java.time.Period;

import com.indus.training.core.domain.AgeCalcInp;
import com.indus.training.core.domain.AgeCalciOut;
import com.indus.training.core.svc.CalcAgeInterface;

public class AgeCalc implements CalcAgeInterface {

	@Override
	public AgeCalciOut AgeCalculator(AgeCalcInp AgeCalcInpObj) {
		// TODO Auto-generated method stub
		AgeCalciOut AgeCalciOutObj = new AgeCalciOut();
		int Year = AgeCalcInpObj.getYear();
		int Month = AgeCalcInpObj.getMonth();
		int Day = AgeCalcInpObj.getDay();
		LocalDate birthDate = LocalDate.of(Year, Month, Day);
		LocalDate todayDate = LocalDate.now();
		int Age = Period.between(birthDate, todayDate).getYears();
		AgeCalciOutObj.setDay(Day);
		AgeCalciOutObj.setMonth(Month);
		AgeCalciOutObj.setYear(Year);
		AgeCalciOutObj.setAge(Age);

		return AgeCalciOutObj;
	}

}
