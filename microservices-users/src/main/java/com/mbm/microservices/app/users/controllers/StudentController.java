package com.mbm.microservices.app.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbm.microservices.app.users.services.StudentService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/students/api")
@Slf4j
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		log.info("Listing all students.");
		return ResponseEntity.ok(studentService.findAll());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) throws NotFoundException {
		log.info("Find studend with id: ," + id);
		return ResponseEntity.ok(studentService.findById(id).orElseThrow(NotFoundException::new));
	}
}
