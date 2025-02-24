package com.indus.training.core.domain;

import java.util.Objects;

public class Student {
	private String FirstName;

	@Override
	public String toString() {
		return "Student [FirstName=" + FirstName + ", LastName=" + LastName + ", RollNumber=" + RollNumber + ", Grade="
				+ Grade + ", Teacher=" + Teacher + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(FirstName, Grade, LastName, RollNumber, Teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(FirstName, other.FirstName) && Grade == other.Grade
				&& Objects.equals(LastName, other.LastName) && RollNumber == other.RollNumber
				&& Teacher == other.Teacher;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getRollNumber() {
		return RollNumber;
	}

	public void setRollNumber(int rollNumber) {
		RollNumber = rollNumber;
	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String string) {
		Teacher = string;
	}

	public Student(String firstName, String lastName, int rollNumber, int grade, String teacher) {
		super();
		FirstName = firstName;
		LastName = lastName;
		RollNumber = rollNumber;
		Grade = grade;
		Teacher = teacher;
	}

	private String LastName;
	private int RollNumber;
	public static int Grade = 10;
	private String Teacher;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
