package com.mbm.microservices.app.users.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbm.microservices.app.users.entity.Student;
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
	public ResponseEntity<?> findById(@PathVariable Long id) {
		log.info("Find studend with id: ," + id);
		Optional<Student> student = studentService.findById(id);
		if (student == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student.get());
	}

	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Long id) {
		Student studentAux = studentService.update(student, id);
		if (studentAux == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentAux));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		log.info("Studend with id: ," + id + " deleted");
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
