package com.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.StudentDto;
import com.security.entities.StudentEntity;
import com.security.response.ResponseMessage;
import com.security.service.StudentService;
import com.security.utils.MessageUtils;

@RestController
public class HomeController {
	
	@Autowired
	private StudentService studentService;

    @Autowired
    private MessageUtils messageUtils;
	
	@GetMapping(value={"/get"})
	public ResponseEntity<ResponseMessage<List<StudentDto>>> getAllStudents() {
		ResponseMessage<List<StudentDto>> response = null;
		List<StudentDto> entity = studentService.getAllStudents();
		if(entity.size()>0) {			
			response = new ResponseMessage<>(messageUtils.getMessage("student.list.fetch"), "200", entity, HttpStatus.OK);
		}else {
			response = new ResponseMessage<>(messageUtils.getMessage("student.list.empty"), "404", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@GetMapping(value={"/get/{id}"})
	public ResponseEntity<ResponseMessage<StudentEntity>> getStudentById(@PathVariable(required = false) int id) {
		ResponseMessage<StudentEntity> response = null;
		StudentEntity entity1 = null ;
		try {			
			StudentDto entity = studentService.getStudentById(id);
			if(entity!=null) {
				response = new ResponseMessage<>(messageUtils.getMessage("student.fetch.success"), "200",entity1, HttpStatus.OK);
			}else {
				response = new ResponseMessage<>(messageUtils.getMessage("student.not.present"), "404", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			
		}
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@PostMapping("/post")
	public ResponseEntity<ResponseMessage<StudentEntity>> insertStudent(@RequestBody StudentEntity entity) {
		ResponseMessage<StudentEntity> response = null;
		try {
			StudentEntity insertStudent = studentService.insertStudent(entity);
			if(insertStudent !=null) {
				response = new ResponseMessage<>(messageUtils.getMessage("student.add.success"), "success", insertStudent, HttpStatus.OK);
			}else {
				response = new ResponseMessage<>(messageUtils.getMessage("student.add.failed"), "400", HttpStatus.BAD_REQUEST);
			}
		 } catch (Exception e) {
	        response = new ResponseMessage<>(messageUtils.getMessage("student.add.failed"), "500", HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<ResponseMessage<StudentEntity>> updateStudent(@PathVariable("id") int id, @RequestBody StudentEntity entity) {
		ResponseMessage<StudentEntity> response = null;
		try {
			Optional<StudentEntity> entities = studentService.getStudentById(id, null);
			if(entities.isPresent()) {
				entities.get().setStudentName(entity.getStudentName());
				StudentEntity studentEntity=studentService.updateStudent(entities.get());
				response = new ResponseMessage<>(messageUtils.getMessage("student.update.success"), "200", studentEntity, HttpStatus.OK);
			}else {
				response = new ResponseMessage<>(messageUtils.getMessage("student.update.failed"), "404", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
	        response = new ResponseMessage<>(messageUtils.getMessage("student.update.failed"), "500", HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage<Void>> delete(@PathVariable("id") int id) {
		ResponseMessage<Void> response = null;
		try {
	        studentService.deleteById(id);
	        response = new ResponseMessage<>(messageUtils.getMessage("student.delete.success"), "200", HttpStatus.OK);
	    } catch (Exception e) {
	        response = new ResponseMessage<>(messageUtils.getMessage("student.delete.failed"), "500", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		return ResponseEntity.status(response.getStatus()).body(response);
	}
	
}
