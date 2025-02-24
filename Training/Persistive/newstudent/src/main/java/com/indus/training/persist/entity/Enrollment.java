package com.indus.training.persist.entity;

import javax.persistence.*;

@Entity
@Table(name = "Enrollment")
public class Enrollment {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private  Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name = "grade")
	private String grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
