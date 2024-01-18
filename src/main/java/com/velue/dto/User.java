package com.velue.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
@Entity
@Table(name = "user")
//@JsonRootName("User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_id")
	private Long userId;
//	@Column(name = "user_name", nullable = false)
	private String userName;
//	@Column(name = "user_password", nullable = false)
	private String userPassword;
//	@Column(name = "first_name")
	private String firstName;
//	@Column(name = "last_name")
	private String lastName;
//	@Column(name = "email_id", nullable = false)
	private String emailId;
//	@Column(name = "user_role", nullable = false)
	private Long userRoleId;
//	@Column(name = "user_status", nullable = false)
	private String userStatus;
//	@Column(name = "updated_by", nullable = false)
	private String updatedBy  ;
//	@Column(name = "Created_at", nullable = false)
	private LocalDateTime createdAt;
//	@Column(name = "updated_at", nullable = false)
	private String phoneNumber;
    // salary details
	private String accountNumber;
	private String bankName;
	private String ifscCode;
	private long salary;
	private String panCard;
	private String aadharCard;
	private String uploadDocument;


	public User(String userName, String userPassword, String firstName, String lastName, String emailId,
			Long userRoleId, String userStatus, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt,String phoneNumber) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.userRoleId = userRoleId;
		this.userStatus = userStatus;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.phoneNumber=phoneNumber;
		this.accountNumber= accountNumber;
		this.bankName=bankName;
		this.ifscCode=ifscCode;
		this.salary=salary;
		this.panCard=panCard;
		this.aadharCard=aadharCard;
		this.uploadDocument=uploadDocument;

	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	private LocalDateTime updatedAt;
	public Long getUserId() {
		return userId;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}



	public String getUploadDocument() {
		return uploadDocument;
	}

	public void setUploadDocument(String uploadDocument) {
		this.uploadDocument = uploadDocument;
	}




}
