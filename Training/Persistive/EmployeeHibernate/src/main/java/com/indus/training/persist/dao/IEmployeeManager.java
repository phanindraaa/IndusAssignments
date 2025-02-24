package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employees;
import java.util.List;

public interface IEmployeeManager {

	public void insert(int id, String name, String phone, String email, String address);

	public Employees fetch(int id);

	public void update(int id, String name, String phone, String email, String address);

	public void delete(int id);

}
