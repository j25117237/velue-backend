package com.velue.dto;

public class UserList {
	private String userName;
	private String userRoleName;
	private String userStatus;
	private String emaildID;
	private Long userId;

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public UserList() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getEmaildID() {
		return emaildID;
	}

	public void setEmaildID(String emaildID) {
		this.emaildID = emaildID;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
