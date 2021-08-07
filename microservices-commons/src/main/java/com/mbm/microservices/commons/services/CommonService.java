package com.mbm.microservices.commons.services;

import java.util.List;
import java.util.Optional;

import javassist.NotFoundException;

public interface CommonService<E> {

	/**
	 * Method to list all entities.
	 * 
	 * @return entity list.
	 */
	List<E> findAll();

	/**
	 * Method to find by identificator.
	 * 
	 * @param id
	 * @return E
	 * @throws NotFoundException 
	 */
	Optional<E> findById(Long id);

	/**
	 * Method to save new entity.
	 * 
	 * @param entity
	 * @return E saved entity.
	 */
	E save(E entity);

	/**
	 * Method to delete element.
	 * 
	 * @param id
	 */
	void delete(Long id);
	
}
