package com.mbm.microservices.app.users.controller;

import java.util.Optional;

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
		Optional<Student> studentToEdit = studentService.findById(id);
		if (studentToEdit.isPresent()) {
			studentToEdit.get().setName(newStudent.getName());
			studentToEdit.get().setLastName(newStudent.getLastName());
			studentToEdit.get().setEmail(newStudent.getEmail());
			studentService.save(studentToEdit.get());
			return ResponseEntity.status(HttpStatus.CREATED).body(studentToEdit);
		} else {
			return ResponseEntity.notFound().build();			
		}
	}

}
