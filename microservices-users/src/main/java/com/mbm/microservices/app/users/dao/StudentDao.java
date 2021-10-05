package com.mbm.microservices.app.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbm.microservices.app.users.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

//	Optional<Student> findByUuid(String  id);
}
