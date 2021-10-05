package com.mbm.microservices.courses.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mbm.microservices.commons.controllers.CommonController;
import com.mbm.microservices.courses.entity.Course;
import com.mbm.microservices.courses.services.CourseServices;

@RestController
public class CourseController extends CommonController<Course, CourseServices>{

	@PutMapping("/update/{uuid}")
	public ResponseEntity<?> update(@Valid @RequestBody Course newStudent, @PathVariable Long id) {
		Course course = commonService.update(newStudent, id);
		if (null != course) {
			return ResponseEntity.status(HttpStatus.CREATED).body(course);
		} else {
			return ResponseEntity.notFound().build();			
		}
	}
}
