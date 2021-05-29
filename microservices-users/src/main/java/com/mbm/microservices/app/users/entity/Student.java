package com.mbm.microservices.app.users.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * @Author: MBMJ
 */

@Data
@EqualsAndHashCode
@Entity
@Table(name = "APP_USERS_STUDENTS")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

}
