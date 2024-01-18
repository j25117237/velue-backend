package com.velue.dto;

public class PendingOrdersCustomer {

    private Long customerId;
    private String customerName;
    private String itemCode;
    private String productName;
    private Long remainingQuantity;
    private Long pendingAmount;

    // Constructors (default and parameterized), getters, and setters

    public PendingOrdersCustomer() {
    }

    public PendingOrdersCustomer(Long customerId, String customerName, String itemCode, String productName, Long remainingQuantity, Long pendingAmount) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.itemCode = itemCode;
        this.productName = productName;
        this.remainingQuantity = remainingQuantity;
        this.pendingAmount = pendingAmount;
    }

    // Getters and setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Long remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

	public Long getPendingAmount() {
		return pendingAmount;
	}

	public void setPendingAmount(Long pendingAmount) {
		this.pendingAmount = pendingAmount;
	}

   

    // Additional methods if needed
}

