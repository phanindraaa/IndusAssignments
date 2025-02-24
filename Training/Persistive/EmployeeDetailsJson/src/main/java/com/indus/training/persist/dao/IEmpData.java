package com.indus.training.persist.dao;


import java.io.IOException;

import com.indus.training.persist.entity.EmpDetails;
import com.indus.training.persist.exception.EmpDataException;

public interface IEmpData {
	public boolean insertEmployee(EmpDetails EmpInfo) throws EmpDataException;
	public boolean updateEmployee(EmpDetails EmpInfo) throws EmpDataException;
	public EmpDetails fetchEmpDetails(int empId) throws EmpDataException, IOException;
	public boolean deleteEmployee(int empId) throws EmpDataException;
}
