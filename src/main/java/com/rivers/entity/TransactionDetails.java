package com.rivers.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TransactionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name = "accountNumber", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private AccountDetails accountDetails;

	@Column(name = "transactionTs")
	private Date transactionTs;

	@Column(name = "type")
	private String type;
	
	@Transient
	@JsonProperty
	private String accountNumber;

	public TransactionDetails() {
		super();
	}

	@Column(name = "amount")
	private double amount;

	public TransactionDetails(long id, AccountDetails accountDetails, Date transactionTs, String type, double amount) {
		super();
		this.id = id;
		this.accountDetails = accountDetails;
		this.accountNumber = accountDetails.getAccountNumber();
		this.transactionTs = transactionTs;
		this.type = type;
		this.amount = amount;
	}
	
	public TransactionDetails(long id, Date transactionTs, String type, double amount,String accountNumber) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.transactionTs = transactionTs;
		this.type = type;
		this.amount = amount;
	}


	public long getId() {
		return id;
	}

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}

	public Date getTransactionTs() {
		return transactionTs;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}

	public void setTransactionTs(Date transactionTs) {
		this.transactionTs = transactionTs;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransactionDetails [id=" + id + ", accountDetails=" + accountDetails.getAccountNumber() + ", transactionTs="
				+ transactionTs + ", type=" + type + ", amount=" + amount + "]";
	}

}
