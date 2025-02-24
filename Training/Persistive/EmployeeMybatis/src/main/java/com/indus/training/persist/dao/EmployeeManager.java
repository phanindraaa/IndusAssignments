package com.indus.training.persist.dao;

import com.indus.training.persist.entity.Employees;
import com.indus.training.persist.exception.EmployeeException;
import com.indus.training.persist.svc.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import com.indus.training.persist.util.MyBatisUtil;

public class EmployeeManager {

    public boolean insertEmployee(Employees employee) throws EmployeeException {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory().openSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            mapper.insertEmployee(employee);
            session.commit();
            System.out.println("Employee inserted successfully with ID: " + employee.getId());
            return true;
        } catch (Exception e) {
            throw new EmployeeException("Error inserting employee", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employees fetchEmployee(int id) throws EmployeeException {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory().openSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            return mapper.fetchEmployee(id);
        } catch (Exception e) {
            throw new EmployeeException("Error fetching employee with ID: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean updateEmployee(Employees employee) throws EmployeeException {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory().openSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            mapper.updateEmployee(employee);
            session.commit();
            System.out.println("Employee updated successfully with ID: " + employee.getId());
            return true;
        } catch (Exception e) {
            throw new EmployeeException("Error updating employee with ID: " + employee.getId(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean deleteEmployee(int id) throws EmployeeException {
        SqlSession session = null;
        try {
            session = MyBatisUtil.getSqlSessionFactory().openSession();
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            mapper.deleteEmployee(id);
            session.commit();
            System.out.println("Employee deleted successfully with ID: " + id);
            return true;
        } catch (Exception e) {
            throw new EmployeeException("Error deleting employee with ID: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
