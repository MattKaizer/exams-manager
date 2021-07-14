package com.mbm.microservices.app.users.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbm.microservices.app.users.dao.StudentDao;
import com.mbm.microservices.app.users.dto.StudentDto;
import com.mbm.microservices.app.users.entity.Student;
import com.mbm.microservices.app.users.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<StudentDto> findAll() {
		return studentDao.findAll().stream().map(student ->
		modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public StudentDto findByUuid(String uuid) {
		Optional<Student> student = studentDao.findByUuid(uuid);
		if (student.isPresent()) {
			StudentDto studentDto = modelMapper.map(student.get(), StudentDto.class);
			return studentDto;
		} else {
			return null;			
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public StudentDto save(StudentDto studentDto) {
		Student student = modelMapper.map(studentDto, Student.class);
		studentDao.save(student);
		StudentDto studentDtoModel = modelMapper.map(student, StudentDto.class);
		return studentDtoModel;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public StudentDto update(StudentDto studentDto, String uuid) {
		Optional<Student> studentEntity = studentDao.findByUuid(uuid);
		if (studentEntity.isPresent()) {
			studentEntity.get().setName(studentDto.getName());
			studentEntity.get().setLastName(studentDto.getLastName());
			studentEntity.get().setEmail(studentDto.getEmail());
			Student student = modelMapper.map(studentEntity, Student.class);
			studentDao.save(student);
			StudentDto studentDtoModel = modelMapper.map(student, StudentDto.class);
			return studentDtoModel;
		} else {
			return null;			
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(String uuid) {
		Optional<Student> studentEntity = studentDao.findByUuid(uuid);
		if (studentEntity.isPresent()) {
			studentDao.deleteById(studentEntity.get().getId());			
		}
	}

}
