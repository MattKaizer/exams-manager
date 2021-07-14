package com.mbm.microservices.app.users.service.impl;

import org.springframework.stereotype.Service;

import com.mbm.microservices.app.users.dao.StudentDao;
import com.mbm.microservices.app.users.entity.Student;
import com.mbm.microservices.app.users.service.StudentService;
import com.mbm.microservices.commons.services.Impl.CommonServiceImpl;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentDao> implements StudentService {
	

}
