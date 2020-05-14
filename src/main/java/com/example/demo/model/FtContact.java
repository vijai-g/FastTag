package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "FT_CONTACT")
@NamedQuery(name = "FtContact.findAll", query = "SELECT f FROM FtContact f")
public class FtContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@OneToOne
	@JoinColumn(name = "FAST_TAG_ID")
	private FastTagPayment fastTagPayment;

	@Enumerated(EnumType.STRING)
	private FastTagStatus status;

}
