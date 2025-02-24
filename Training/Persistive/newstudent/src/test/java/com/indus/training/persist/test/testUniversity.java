package com.indus.training.persist.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.indus.training.persist.dao.UniversityDao;
import com.indus.training.persist.entity.Course;
import com.indus.training.persist.entity.Department;
import com.indus.training.persist.entity.Enrollment;
import com.indus.training.persist.entity.Instructor;
import com.indus.training.persist.entity.Student;
import com.indus.training.persist.util.HibernateUtil;

public class testUniversity {
	
	private UniversityDao dao;
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		dao = new UniversityDao();
		entityManager = HibernateUtil.getEntityManager();
		entityManager.getTransaction().begin();
		pretestData();
		entityManager.getTransaction().commit();
	}

	@After
	public void tearDown() throws Exception {
		if (entityManager.getTransaction().isActive()){
			entityManager.getTransaction().rollback();
		}
		
		entityManager.close();
		dao = null;
	}

	public void pretestData() {
		  // Insert test data into the tables
        Department dept = new Department();
        dept.setDepartmentName("Computer Science");
        entityManager.persist(dept);

        Student student1 = new Student();
        student1.setName("Alice");
        student1.setEmail("alice@example.com");
        student1.setDepartment(dept);
        entityManager.persist(student1);

        Course course1 = new Course();
        course1.setCourseName("Math 101");
        entityManager.persist(course1);

        Instructor instructor1 = new Instructor();
        instructor1.setInstructorName("Dr. John");
        instructor1.setDepartment(dept);
        instructor1.getCourses().add(course1);
        entityManager.persist(instructor1);

        Enrollment enrollment1 = new Enrollment();
        enrollment1.setStudent(student1);
        enrollment1.setCourse(course1);
        enrollment1.setGrade("A");
        entityManager.persist(enrollment1);
	}

	 // HQL Tests
    @Test
    public void testGetStudentsEnrolledInCourse() {
        List<Student> students = dao.getStudentsEnrolledInCourse("Math 101");
        assertEquals(2, students.size()); // Alice and Bob
    }

    @Test
    public void testGetInstructorsByCourse() {
        List<Instructor> instructors = dao.getInstructorsByCourse("Math 101");
        assertEquals(1, instructors.size());
        assertEquals("Dr. John", instructors.get(0).getInstructorName());
    }

    @Test
    public void testGetStudentCountInDepartment() {
        Long count = dao.getStudentCountInDepartment("Computer Science");
        assertEquals(Long.valueOf(2), count); // Alice and Bob
    }

    // JPQL Tests
    @Test
    public void testGetCoursesByDepartment() {
        List<Course> courses = dao.getCoursesByDepartment("Computer Science");
        assertEquals(2, courses.size()); // Math 101 and Physics 101
    }

    @Test
    public void testGetInstructorsByDepartment() {
        List<Instructor> instructors = dao.getInstructorsByDepartment("Computer Science");
        assertEquals(1, instructors.size());
        assertEquals("Dr. John", instructors.get(0).getInstructorName());
    }

    @Test
    public void testGetStudentsByGrade() {
        List<Student> students = dao.getStudentsByGrade("A");
        assertEquals(1, students.size());
        assertEquals("Alice", students.get(0).getName());
    }

    // Native SQL Tests
    @Test
    public void testListAllDepartments() {
        List<Department> departments = dao.listAllDepartments();
        assertEquals(1, departments.size());
        assertEquals("Computer Science", departments.get(0).getDepartmentName());
    }

    @Test
    public void testGetTotalCourses() {
        Long totalCourses = dao.getTotalCourses();
        assertEquals(Long.valueOf(2), totalCourses); // Math 101 and Physics 101
    }

    @Test
    public void testFindStudentsByEmail() {
        List<Student> students = dao.findStudentsByEmail("alice@example.com");
        assertEquals(1, students.size());
        assertEquals("Alice", students.get(0).getName());
    }
	
	

}
