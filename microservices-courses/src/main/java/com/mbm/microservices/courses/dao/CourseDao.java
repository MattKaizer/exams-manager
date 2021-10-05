package com.mbm.microservices.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbm.microservices.courses.entity.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
