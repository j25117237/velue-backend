package com.velue.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankReferenceId;
	private String accountNumber;
	private String bankName;
	private String ifscCode;
	private String panCard;

	public long getBankReferenceId() {
		return bankReferenceId;
	}

	public void setBankReferenceId(long bankReferenceId) {
		this.bankReferenceId = bankReferenceId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public CustomerBankDetails() {
		// TODO Auto-generated constructor stub
	}

}
