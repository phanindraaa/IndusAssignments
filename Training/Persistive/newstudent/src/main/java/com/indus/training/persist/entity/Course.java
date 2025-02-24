package com.indus.training.persist.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "course_name")
	private String courseName;
	
	@ManyToMany(mappedBy = "courses")
	private List<Instructor> instructors;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Enrollment> enrollments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
}
