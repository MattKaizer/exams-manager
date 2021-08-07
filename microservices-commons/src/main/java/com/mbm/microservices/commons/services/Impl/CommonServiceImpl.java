package com.mbm.microservices.commons.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mbm.microservices.commons.services.CommonService;

public class CommonServiceImpl<E, R extends JpaRepository<E, Long>> implements CommonService<E> {
	
	@Autowired
	protected R repository;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<E> findAll() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public E save(E entity) {
		return repository.save(entity);
	}

//	@Override
//	@Transactional
//	public E update(E newEntity, Long id) {
//		Optional<E> studentEntity = studentDao.findById(id);
//		if (studentEntity.isPresent()) {
//			studentEntity.get().setName(newEntity.getName());
//			studentEntity.get().setLastName(newEntity.getLastName());
//			studentEntity.get().setEmail(newEntity.getEmail());
//			studentDao.save(studentEntity);
//			return studentDtoModel;
//		} else {
//			return null;			
//		}
//	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		Optional<E> studentEntity = repository.findById(id);
		if (studentEntity.isPresent()) {
			repository.deleteById(id);			
		}
	}

}
