package com.mbm.microservices.app.users.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.mbm.microservices.app.users.dto.StudentDto;

public interface StudentService {

	/**
	 * Method to list all students.
	 * 
	 * @return students list.
	 */
	public List<StudentDto> findAll();

	/**
	 * Method to find by identificator.
	 * 
	 * @param id
	 * @return student
	 * @throws NotFoundException 
	 */
	public StudentDto findByUuid(String uuid);

	/**
	 * Method to save new entity.
	 * 
	 * @param student
	 * @return saved student.
	 */
	public StudentDto save(StudentDto studentDto);

	/**
	 * Method to delete element.
	 * 
	 * @param id
	 */
	public void delete(String uuid);
	
	/**
	 * 
	 * @param student
	 * @param id
	 * @return edited student
	 */
	public StudentDto update(StudentDto studentDto, String uuid);
	
}
