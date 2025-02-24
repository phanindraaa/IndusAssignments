package com.indus.training.persist.dao;

import com.indus.training.persist.entity.EmployeeOffice;

public interface IEmployeeOffice {

    public void insert(EmployeeOffice office);

    public EmployeeOffice fetch(int officeId);

    public void update(EmployeeOffice office);

    public void delete(int officeId);

}
