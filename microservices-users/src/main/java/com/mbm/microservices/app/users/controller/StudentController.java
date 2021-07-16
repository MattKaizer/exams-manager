package com.mbm.microservices.app.users.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mbm.microservices.app.users.entity.Student;
import com.mbm.microservices.app.users.service.StudentService;
import com.mbm.microservices.commons.controllers.CommonController;

@RestController
public class StudentController extends CommonController<Student, StudentService> {

	@PutMapping("/update/{uuid}")
	public ResponseEntity<?> update(@Valid @RequestBody Student newStudent, @PathVariable Long id) {
		Student student = studentService.update(newStudent, id);
		if (null != student) {
			return ResponseEntity.status(HttpStatus.CREATED).body(student);
		} else {
			return ResponseEntity.notFound().build();			
		}
	}

}
