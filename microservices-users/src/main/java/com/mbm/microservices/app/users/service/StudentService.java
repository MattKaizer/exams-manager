package com.mbm.microservices.app.users.service;

import com.mbm.microservices.app.users.entity.Student;
import com.mbm.microservices.commons.services.CommonService;

public interface StudentService extends CommonService<Student> {

	public Student update(Student newEntity, Long id);
}
