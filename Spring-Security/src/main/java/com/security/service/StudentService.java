package com.security.service;

import java.util.List;
import java.util.Optional;

import com.security.dto.StudentDto;
import com.security.entities.StudentEntity;

public interface StudentService {

	List<StudentDto> getAllStudents();

	void deleteById(int id);

	StudentEntity insertStudent(StudentEntity entity);

	Optional<StudentEntity> getStudentById(Integer id, Object object);
	
	StudentDto getStudentById(int id);

	StudentEntity updateStudent(StudentEntity entity);

}
