package com.velue.dto;

public class LowSellingProduct {
	
    private String productName;
    private Long productId;
    private Long totalQuantitySold;
    
    public LowSellingProduct()
    {
    	
    }
    
	public LowSellingProduct(String productName, Long productId, Long totalQuantitySold) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.totalQuantitySold = totalQuantitySold;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getTotalQuantitySold() {
		return totalQuantitySold;
	}
	public void setTotalQuantitySold(Long totalQuantitySold) {
		this.totalQuantitySold = totalQuantitySold;
	}
    
    

}
