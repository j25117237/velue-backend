package com.velue.dto;

public class PendingOrdersProduct {

	private String brandName;
    private String categoryName;
    private String itemCode;
    private String productName;
    private Long remainingQuantity;
    private Long pendingAmount;

    // Constructors (default and parameterized), getters, and setters

    public PendingOrdersProduct() {
    }

    
	public PendingOrdersProduct(String brandName, String categoryName, String itemCode, String productName,
			Long remainingQuantity, Long pendingAmount) {
	
		this.brandName = brandName;
		this.categoryName = categoryName;
		this.itemCode = itemCode;
		this.productName = productName;
		this.remainingQuantity = remainingQuantity;
		this.pendingAmount = pendingAmount;
	}


	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
    
    

}