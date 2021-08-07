package com.mbm.microservices.app.users.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mbm.microservices.app.users.dao.StudentDao;
import com.mbm.microservices.app.users.entity.Student;
import com.mbm.microservices.app.users.service.StudentService;
import com.mbm.microservices.commons.services.Impl.CommonServiceImpl;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentDao> implements StudentService {

	@Override
	@Transactional
	public Student update(Student newEntity, Long id) {
		Optional<Student> studentEntity = repository.findById(id);
		if (studentEntity.isPresent()) {
			studentEntity.get().setName(newEntity.getName());
			studentEntity.get().setLastName(newEntity.getLastName());
			studentEntity.get().setEmail(newEntity.getEmail());
			repository.save(studentEntity.get());
			return studentEntity.get();
		} else {
			return null;			
		}
	}
}
