package com.velue;

public interface RestockProductsResponse {
  String getProductName();
  Long getRestockLevel();
  Long getStockInHand();
  String image();
}
