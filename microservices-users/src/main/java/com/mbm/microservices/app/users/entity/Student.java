package com.mbm.microservices.app.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * @Author: MBMJ
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "APP_USERS_STUDENTS")
public class Student extends Auditable {
	
	private static final long serialVersionUID = 7189914580222785969L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;

}
