package com.mbm.microservices.app.users.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
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

import com.mbm.microservices.app.users.dto.StudentDto;
import com.mbm.microservices.app.users.service.StudentService;

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
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		log.info("Listing all students.");
		return ResponseEntity.ok(studentService.findAll());
	}

	@GetMapping("/get/{uuid}")
	public ResponseEntity<?> findById(@PathVariable String uuid) {
		log.info("Find studend with id: ," + uuid);
		StudentDto student = studentService.findByUuid(uuid);
		if (null == student) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

	@PostMapping("/save")
	public ResponseEntity<?> create(@Valid @RequestBody StudentDto studentDto) {
		if (null == studentDto) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDto));
	}

	@PutMapping("/update/{uuid}")
	public ResponseEntity<?> update(@Valid @RequestBody StudentDto studentDto, @PathVariable String uuid) {
		StudentDto studentToEdit = studentService.update(studentDto, uuid);
		if (null == studentToEdit) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentToEdit));
	}
	
	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		log.info("Studend with id: ," + uuid + " deleted");
		return ResponseEntity.noContent().build();
	}

}
