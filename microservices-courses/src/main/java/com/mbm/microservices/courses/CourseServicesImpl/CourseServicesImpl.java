package com.mbm.microservices.courses.CourseServicesImpl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mbm.microservices.commons.services.Impl.CommonServiceImpl;
import com.mbm.microservices.courses.dao.CourseDao;
import com.mbm.microservices.courses.entity.Course;
import com.mbm.microservices.courses.services.CourseServices;

@Service
public class CourseServicesImpl extends CommonServiceImpl<Course, CourseDao> implements CourseServices {

	@Override
	@Transactional
	public Course update(Course newEntity, Long id) {
		Optional<Course> studentEntity = repository.findById(id);
		if (studentEntity.isPresent()) {
			studentEntity.get().setName(newEntity.getName());
			repository.save(studentEntity.get());
			return studentEntity.get();
		} else {
			return null;			
		}
	}
}
