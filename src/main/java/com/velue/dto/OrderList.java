package com.velue.dto;

public class OrderList {
	private String gstno;
	private String orderStatus;
	private String firstName;
	private String lastName;

	public OrderList() {

	}

	public OrderList(String gstno, String orderStatus, String firstName, String lastName) {
		this.gstno = gstno;
		this.orderStatus = orderStatus;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public String getGstno() {
		return gstno;
	}

	public void setGstno(String gstno) {
		this.gstno = gstno;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

}
