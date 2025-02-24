package com.indus.training.persist.dac;


import java.io.IOException;
import java.sql.SQLException;

import com.indus.training.persist.entity.EmpDetails;
import com.indus.training.persist.exception.EmpDataException;

public interface IEmpData {
	public boolean insertEmployee(EmpDetails EmpInfo) throws EmpDataException;
	public boolean updateEmployee(EmpDetails EmpInfo) throws EmpDataException;
	public EmpDetails fetchEmpDetails(int empId) throws EmpDataException, IOException, SQLException;
	public boolean deleteEmployee(int empId) throws EmpDataException;
}
