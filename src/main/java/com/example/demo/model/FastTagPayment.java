package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Data;

@Data
@Entity
@Table(name = "FAST_TAG_PAYMENT")
@NamedQuery(name = "FastTagPayment.findAll", query = "SELECT f FROM FastTagPayment f")
public class FastTagPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FAST_TAG_ID")
	private String fastTagId;

	@CreationTimestamp
	@Column(name = "DATE_BEGIN")
	private LocalDate dateBegin;

	@Column(name = "DATE_EXPIRY")
	private LocalDate dateExpiry;

	@Column(name = "OWNER_NAME")
	private String ownerName;

	@Column(name = "VEHICLE_REG_NO")
	private String vehicleRegNo;

	@Column(name = "MOBILE_NO")
	private BigDecimal mobileNo;

	// bi-directional many-to-one association to AccountUser
	@ManyToOne
	@JoinColumn(name = "CIF")
	private AccountUser accountUser;

	@PrePersist
	private void prePersistFunction() {

		// log.info("PrePersist method called");

		if (StringUtils.isEmpty(getOwnerName())) {
			System.out.println("OwnerName is Empty");
		}
	}

	@PreUpdate
	public void preUpdateFunction() {
		// log.info("PreUpdate method called");
		if (StringUtils.isEmpty(getOwnerName())) {
			System.out.println("OwnerName is Empty");
		}
	}
}
