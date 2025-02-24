package com.indus.training.core.svc;

import com.indus.training.core.domain.Student;

import junit.framework.TestCase;

public class testStudent extends TestCase {
	
	private Student student1;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		student1 = null;
	}
	
	public void testStudent() {
		Student student1 = new Student();
		student1.setFirstName("Phani");
		student1.setLastName("sai");
		student1.setGrade(10);
		student1.setRollNumber(37);
		student1.setTeacher("Vivek");
		System.out.println(student1);
		
		Student student2 = new Student();
		student2.setFirstName("venkata");
		student2.setLastName("sai");
		student2.setGrade(Student.Grade);
		student2.setRollNumber(73);
		student2.setTeacher("Vivek");
		System.out.println(student2.getFirstName());
		System.out.println(student2);
		
	}

}
