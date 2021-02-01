package com.rivers.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class AccountDetails{
	@Id	
	@Column(name="accountNumber")
	private String accountNumber;	

	@Column(name="balance")
	private double balance;
	
	@Column(name="lastUpdateTimestamp")
	private String lastUpdateTimestamp;
	
	@OneToMany(mappedBy="accountDetails")
    private List<TransactionDetails> transactionDetails;
	
	public AccountDetails() {
		super();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public AccountDetails(String accountNumber, double balance, String lastUpdateTimestamp,
			List<TransactionDetails> transactionDetails) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.lastUpdateTimestamp = lastUpdateTimestamp;
		this.transactionDetails = transactionDetails;
	}

	@Override
	public String toString() {
		final int maxLen = 1;
		return "AccountDetails [accountNumber=" + accountNumber + ", balance=" + balance + ", lastUpdateTimestamp="
				+ lastUpdateTimestamp + ", transactionDetails="
				+ (transactionDetails != null
						? transactionDetails.subList(0, Math.min(transactionDetails.size(), maxLen))
						: null)
				+ "]";
	}

	
}
