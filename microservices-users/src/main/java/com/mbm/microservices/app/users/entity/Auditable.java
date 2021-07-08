package com.mbm.microservices.app.users.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
public class Auditable implements Serializable {

	private static final long serialVersionUID = -2390327493854210772L;

	@CreatedDate
	@Column(name = "CREATED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	@LastModifiedDate
	@Column(name = "MODIFIED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;
	@Column(name = "DELETED_AT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;

}
