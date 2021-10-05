package com.mbm.microservices.courses.services;

import com.mbm.microservices.commons.services.CommonService;
import com.mbm.microservices.courses.entity.Course;

public interface CourseServices extends CommonService<Course> {

	public Course update(Course newEntity, Long id);
}
