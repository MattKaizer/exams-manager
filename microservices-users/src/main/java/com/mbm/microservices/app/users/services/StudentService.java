package com.mbm.microservices.app.users.services;

import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.mbm.microservices.app.users.entity.Student;

public interface StudentService {

	/**
	 * Method to list all students.
	 * 
	 * @return students list.
	 */
	public Iterable<Student> findAll();

	/**
	 * Method to find by identificator.
	 * 
	 * @param id
	 * @return student
	 * @throws NotFoundException 
	 */
	public Optional<Student> findById(Long id);

	/**
	 * Method to save new entity.
	 * 
	 * @param student
	 * @return saved student.
	 */
	public Student save(Student student);

	/**
	 * Method to delete element.
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 
	 * @param student
	 * @param id
	 * @return edited student
	 */
	public Student update(Student student, Long id);
	
}
