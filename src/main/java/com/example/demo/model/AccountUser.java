package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="ACCOUNT_USER")
@NamedQuery(name="AccountUser.findAll", query="SELECT a FROM AccountUser a")
public class AccountUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CIF")
	private long cif;

	@Column(name="ACC_HOLDER_NAME")
	private String accHolderName;

	@Column(name="ACCOUNT_NUMBER")
	private BigDecimal accountNumber;

	@Column(name="DEBIT_CARD_NO")
	private BigDecimal debitCardNo;

	@Column(name="LOCATION")
	private String location;

	//bi-directional many-to-one association to FastTagPayment
	//@OneToMany(mappedBy="accountUser")
	//private List<FastTagPayment> fastTagPayments;


}


