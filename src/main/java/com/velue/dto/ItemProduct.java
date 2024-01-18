package com.velue.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "itemproduct")
public class ItemProduct {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderProductId;

  public Long productId;
  private Long orderQuantity;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  //private Date createdAt;
  private Date createdAt;

  @Transient
  private String productName;

  @Transient
  private String productDescription;

  @Transient
  private String itemDescription;

  @Transient
  private Long pricePerPackage;

  @Transient
  private String packagingType;

  @Transient
  private Long amount;

  @Transient
  private String ItemCode;

  @Transient
  @Lob
  private String image;

  private Long remainingQuantity;

  public Long getRemainingQuantity() {
    return remainingQuantity;
  }

  public void setRemainingQuantity(Long remainingQuantity) {
    this.remainingQuantity = remainingQuantity;
  }

  public String getItemCode() {
    return ItemCode;
  }

  public void setItemCode(String itemCode) {
    ItemCode = itemCode;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public String getPackagingType() {
    return packagingType;
  }

  public void setPackagingType(String packagingType) {
    this.packagingType = packagingType;
  }

  public void setOrderQuantity(Long orderQuantity) {
    this.orderQuantity = orderQuantity;
  }

  public Long getPricePerPackage() {
    return pricePerPackage;
  }

  public void setPricePerPackage(Long pricePerPackage) {
    this.pricePerPackage = pricePerPackage;
  }

  @Column(name = "order_id")
  private Long orderId;

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getOrderProductId() {
    return orderProductId;
  }

  public void setOrderProductId(Long orderProductId) {
    this.orderProductId = orderProductId;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Long getOrderQuantity() {
    return orderQuantity;
  }

  public void setOrderQuantity(long orderQuantity) {
    this.orderQuantity = orderQuantity;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }
}
