package com.indus.training.persist.svc;

import org.apache.ibatis.annotations.*;
import com.indus.training.persist.entity.Employees;

@Mapper
public interface EmployeeMapper {
    
    @Insert("INSERT INTO Employees (id, name, phone, email, address) VALUES (#{id}, #{name}, #{phone}, #{email}, #{address})")
    public boolean insertEmployee(Employees employee);

    @Select("SELECT id, name, phone, email, address FROM Employees WHERE id = #{id}")
    public Employees fetchEmployee(int id);

    @Update("UPDATE Employees SET name = #{name}, phone = #{phone}, email = #{email}, address = #{address} WHERE id = #{id}")
    public boolean updateEmployee(Employees employee);

    @Delete("DELETE FROM Employees WHERE id = #{id}")
    public boolean deleteEmployee(int id);
}
