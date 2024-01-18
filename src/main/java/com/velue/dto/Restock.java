package com.velue.dto;


	public class Restock {
	    private Long productId;
	    private String productName;
	    private String categoryName;
	    private String brandName;
	    private Long stockInHand;
	    private Long reStockLevel;
	    private Long quantityToOrder;
	    
	    public Restock()
	    {
	    	
	    }

	    // Constructors, getters, and setters

	    public Restock(Long productId, String productName, String categoryName, String brandName,
	                         Long stockInHand, Long reStockLevel, Long quantityToOrder) {
	        this.productId = productId;
	        this.productName = productName;
	        this.categoryName = categoryName;
	        this.brandName = brandName;
	        this.stockInHand = stockInHand;
	        this.reStockLevel = reStockLevel;
	        this.quantityToOrder = quantityToOrder;
	    }

	    // Getters and setters for each field

	    public Long getProductId() {
	        return productId;
	    }

	    public void setProductId(Long productId) {
	        this.productId = productId;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public String getCategoryName() {
	        return categoryName;
	    }

	    public void setCategoryName(String categoryName) {
	        this.categoryName = categoryName;
	    }

	    public String getBrandName() {
	        return brandName;
	    }

	    public void setBrandName(String brandName) {
	        this.brandName = brandName;
	    }

	    public Long getStockInHand() {
	        return stockInHand;
	    }

	    public void setStockInHand(Long stockInHand) {
	        this.stockInHand = stockInHand;
	    }

	    public Long getReStockLevel() {
	        return reStockLevel;
	    }

	    public void setReStockLevel(Long reStockLevel) {
	        this.reStockLevel = reStockLevel;
	    }

	    public Long getQuantityToOrder() {
	        return quantityToOrder;
	    }

	    public void setQuantityToOrder(Long quantityToOrder) {
	        this.quantityToOrder = quantityToOrder;
	    }
	}



