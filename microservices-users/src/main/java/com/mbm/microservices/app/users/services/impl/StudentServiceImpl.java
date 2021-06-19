package com.mbm.microservices.app.users.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbm.microservices.app.users.dao.StudentDao;
import com.mbm.microservices.app.users.entity.Student;
import com.mbm.microservices.app.users.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Iterable<Student> findAll() {
		return studentDao.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<Student> findById(Long id) {
		Optional<Student> student = studentDao.findById(id);
		if (student.isPresent()) {
			return student;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Student save(Student student) {
		return studentDao.save(student);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Student update(Student student, Long id) {
		Optional<Student> studentToEdit = studentDao.findById(id);
		if (studentToEdit.isPresent()) {
			studentToEdit.get().setName(student.getName());
			studentToEdit.get().setLastName(student.getLastName());
			studentToEdit.get().setEmail(student.getEmail());
			return studentDao.save(student);
		} 
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		studentDao.deleteById(id);
	}

}
