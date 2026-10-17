package com.security.dto;

import java.io.Serializable;

public class StudentDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String studentName;
	
	public StudentDto() {}
	
	public StudentDto(int id, String studentName) {
		this.id = id;
		this.studentName = studentName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
