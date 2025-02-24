package com.indus.training.core.svc;

import com.indus.training.core.domain.CalcInput;
import com.indus.training.core.domain.CalcOutput;

public interface ICalci {
	
	public abstract CalcOutput add(CalcInput CalcInObj);
	public CalcOutput sub(CalcInput CalcInObj);
	public CalcOutput mul(CalcInput CalcInObj);
	public CalcOutput div(CalcInput CalcInObj); 

}
