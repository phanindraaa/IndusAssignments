package com.indus.training.persist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.indus.training.persist.entity.Course;
import com.indus.training.persist.entity.Department;
import com.indus.training.persist.entity.Instructor;
import com.indus.training.persist.entity.Student;
import com.indus.training.persist.util.HibernateUtil;

import org.hibernate.Query;

public class UniversityDao {
	
	 // HQL Queries
    public List<Student> getStudentsEnrolledInCourse(String courseName) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String hql = "SELECT e.student FROM Enrollment e WHERE e.course.courseName = :courseName";
        TypedQuery<Student> query = entityManager.createQuery(hql, Student.class);
        query.setParameter("courseName", courseName);
        return query.getResultList();
    }

    public List<Instructor> getInstructorsByCourse(String courseName) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String hql = "SELECT i FROM Instructor i JOIN i.courses c WHERE c.courseName = :courseName";
        TypedQuery<Instructor> query = entityManager.createQuery(hql, Instructor.class);
        query.setParameter("courseName", courseName);
        return query.getResultList();
    }

    public Long getStudentCountInDepartment(String departmentName) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String hql = "SELECT COUNT(s) FROM Student s WHERE s.department.departmentName = :departmentName";
        TypedQuery<Long> query = entityManager.createQuery(hql, Long.class);
        query.setParameter("departmentName", departmentName);
        return query.getSingleResult();
    }

    // JPQL Queries
    public List<Course> getCoursesByDepartment(String departmentName) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String jpql = "SELECT c FROM Course c JOIN c.instructors i WHERE i.department.departmentName = :departmentName";
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        query.setParameter("departmentName", departmentName);
        return query.getResultList();
    }

    public List<Instructor> getInstructorsByDepartment(String departmentName) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String jpql = "SELECT i FROM Instructor i WHERE i.department.departmentName = :departmentName";
        TypedQuery<Instructor> query = entityManager.createQuery(jpql, Instructor.class);
        query.setParameter("departmentName", departmentName);
        return query.getResultList();
    }

    public List<Student> getStudentsByGrade(String grade) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String jpql = "SELECT s FROM Student s JOIN Enrollment e ON s.id = e.student.id WHERE e.grade = :grade";
        TypedQuery<Student> query = entityManager.createQuery(jpql, Student.class);
        query.setParameter("grade", grade);
        return query.getResultList();
    }

    // Native SQL Queries
    @SuppressWarnings("unchecked")
	public List<Department> listAllDepartments() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT * FROM Department";
        javax.persistence.Query query = entityManager.createNativeQuery(sql, Department.class);
        return query.getResultList();
    }

    public Long getTotalCourses() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT COUNT(*) FROM Course";
        javax.persistence.Query query = entityManager.createNativeQuery(sql);
        return ((Number) query.getSingleResult()).longValue();
    }

    @SuppressWarnings("unchecked")
	public List<Student> findStudentsByEmail(String email) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
        String sql = "SELECT * FROM Student WHERE email = :email";
        javax.persistence.Query query = entityManager.createNativeQuery(sql, Student.class);
        query.setParameter("email", email);
        return query.getResultList();
    }
	
	
}
