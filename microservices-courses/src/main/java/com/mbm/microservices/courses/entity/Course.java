package com.mbm.microservices.courses.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mbm.microservices.commons.auditable.Auditable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * @Author: MBMJ
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "APP_COURSES")
public class Course extends Auditable {

	private static final long serialVersionUID = 7189914580222785969L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;

}
