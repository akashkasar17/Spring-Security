package com.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dao.StudentRepository;
import com.security.dto.StudentDto;
import com.security.entities.StudentEntity;
import com.security.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;

	@Override
	public  List<StudentDto> getAllStudents() {
		List<StudentEntity> findAll = studentRepository.findAll();
        List<StudentDto> list = findAll.stream()
                .map(studentEntity -> new StudentDto(studentEntity.getId(), studentEntity.getStudentName()))
                .collect(Collectors.toList());
		return list;
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public StudentEntity insertStudent(StudentEntity entity) {
		StudentEntity studentEntity = studentRepository.save(entity);
		return studentEntity;
	}

	@Override
	public Optional<StudentEntity> getStudentById(Integer id, Object object) {
		return studentRepository.findById(id);
	}

	@Override
	public StudentEntity updateStudent(StudentEntity entity) {
		StudentEntity updatedStudent = studentRepository.save(entity);
		return updatedStudent;
	}

	@Override
	public StudentDto getStudentById(int id) {
		StudentDto dto = new StudentDto();
		Optional<StudentEntity> findById = studentRepository.findById(id);
		BeanUtils.copyProperties(findById, dto);
		return dto;
	}
	
	
}
