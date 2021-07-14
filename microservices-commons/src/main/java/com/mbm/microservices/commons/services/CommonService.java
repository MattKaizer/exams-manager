package com.mbm.microservices.commons.services;

import java.util.List;
import java.util.Optional;

import javassist.NotFoundException;

public interface CommonService<E> {

	/**
	 * Method to list all students.
	 * 
	 * @return students list.
	 */
	public List<E> findAll();

	/**
	 * Method to find by identificator.
	 * 
	 * @param id
	 * @return student
	 * @throws NotFoundException 
	 */
	public Optional<E> findById(Long id);

	/**
	 * Method to save new entity.
	 * 
	 * @param student
	 * @return saved student.
	 */
	public E save(E entity);

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
//	public E update(E entity, Long id);
	
}
