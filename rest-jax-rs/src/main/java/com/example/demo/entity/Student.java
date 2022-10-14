package com.example.demo.entity;

public class Student {
	
	int rollNumber;
	String studentName;
	double markSored;
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getMarkSored() {
		return markSored;
	}
	public void setMarkSored(double markSored) {
		this.markSored = markSored;
	}
	public Student(int rollNumber, String studentName, double markSored) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.markSored = markSored;
	}
	

}
