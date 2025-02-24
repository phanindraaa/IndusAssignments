package com.indus.training.core.svc;

public interface ITokenGen {

	public void dynamicAlloc(int number);

	public String getArray();

	public int getArraySize();

	void getNumAt(int index) throws ArrayIndexOutOfBoundsException;
}
