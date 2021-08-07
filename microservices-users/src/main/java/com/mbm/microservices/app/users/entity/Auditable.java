package com.mbm.microservices.app.users.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable implements Serializable {

	private static final long serialVersionUID = -2390327493854210772L;

    @Column(name = "UUID", updatable = false, nullable = true, unique = true)
    private String uuid; 
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
	
    @PrePersist
    public void initializeUUID() {
    	// @GeneratedValue actua sobre @Id solo. Se empleara java.util.
        if (this.uuid == null || "".equals(uuid.trim())) {
            this.uuid = UUID.randomUUID().toString().replace("-", "").substring(0,  19);
        }
    }

}
