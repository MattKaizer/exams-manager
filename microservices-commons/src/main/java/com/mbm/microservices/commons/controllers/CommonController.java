package com.mbm.microservices.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mbm.microservices.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S studentService;

	@GetMapping("/")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(studentService.findAll());
	}

	@GetMapping("/get/{uuid}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<E> entity = studentService.findById(id);
		if (!entity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@PostMapping("/save")
	public ResponseEntity<?> create(@RequestBody E entity) {
		if (null == entity) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(entity));
	}
	
	@DeleteMapping("/delete/{uuid}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return ResponseEntity.noContent().build();
	}

}
