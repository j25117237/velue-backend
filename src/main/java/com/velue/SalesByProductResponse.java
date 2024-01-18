package com.velue;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class SalesByProductResponse {

//   private String productName;
//   private String productId;
//   private Long orderQuantity;
//   private Long stockInHand;
//   private Long pricePerPackage;

//   public String getProductName() {
//     return productName;
//   }

//   public void setProductName(String productName) {
//     this.productName = productName;
//   }

//   public String getItemCode() {
//     return itemCode;
//   }

//   public void setItemCode(String itemCode) {
//     this.itemCode = itemCode;
//   }

//   public Long getOrderQuantity() {
//     return orderQuantity;
//   }

//   public void setOrderQuantity(Long orderQuantity) {
//     this.orderQuantity = orderQuantity;
//   }

//   public Long getStockInHand() {
//     return stockInHand;
//   }

//   public void setStockInHand(Long stockInHand) {
//     this.stockInHand = stockInHand;
//   }

//   public Long getPricePerPackage() {
//     return pricePerPackage;
//   }

//   public void setPricePerPackage(Long pricePerPackage) {
//     this.pricePerPackage = pricePerPackage;
//   }
// }

public interface SalesByProductResponse {
  String getProductName();
  String getProductId();
  Long getOrderQuantity();
  Long getStockInHand();
  Long getPricePerPackage();
  // private String productName;
  //   private String productId;
  //   private Long orderQuantity;
  //   private Long stockInHand;
  //   private Long pricePerPackage;
}
