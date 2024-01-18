package com.velue.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "product")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  // Item Details
  @Column(length = 1000)
  private String productName;

  private String modelName;

  @Transient
  private String categoryName;

  private String groupCode;
  private Long unitId;

  @Transient
  private String unitName;

  private Long brandId;
  private Long weightId;

  @Transient
  private String brandName;

  @Transient
  private String WeightUnitName;

  public String getWeightUnitName() {
    return WeightUnitName;
  }

  public void setWeightUnitName(String weightUnitName) {
    WeightUnitName = weightUnitName;
  }

  // private String productDescription;
  private String itemDescription;
  private String packing_type;
  private Long categoryId;
  private long weight;

  // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  // @JoinColumn(name = "brandId", insertable = false, updatable = false)
  // private Brand brand;

  // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  // @JoinColumn(name = "categoryId", insertable = false, updatable = false)
  // // @Transient
  // static Category category;

  // @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  // @JoinColumn(name = "unitId", insertable = false, updatable = false)
  // // @Transient
  // static Unit unit;

  private String ItemCode;

  @Column(length = 5000)
  private String productDescription;

  // @Lob
  private String imageName;

  private Long stockInHand;
  private Long reStockLevel;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt = new Date(); // initialize created date

  @UpdateTimestamp
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  private String Status;
  // private String imageType;

  private Long unitsPerPackaging;

  private Long pricePerPackage;
  private Long minOrderQuantity;
  private Long maxOrderQuantity;

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public Long getUnitsPerPackaging() {
    return unitsPerPackaging;
  }

  public void setUnitsPerPackaging(Long unitsPerPackaging) {
    this.unitsPerPackaging = unitsPerPackaging;
  }

  public Long getPricePerPackage() {
    return pricePerPackage;
  }

  public void setPricePerPackage(Long pricePerPackage) {
    this.pricePerPackage = pricePerPackage;
  }

  public Long getMinOrderQuantity() {
    return minOrderQuantity;
  }

  public void setMinOrderQuantity(Long minOrderQuantity) {
    this.minOrderQuantity = minOrderQuantity;
  }

  public Long getMaxOrderQuantity() {
    return maxOrderQuantity;
  }

  public void setMaxOrderQuantity(Long maxOrderQuantity) {
    this.maxOrderQuantity = maxOrderQuantity;
  }

  public long getWeight() {
    return weight;
  }

  public void setWeight(long weight) {
    this.weight = weight;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getGroupCode() {
    return groupCode;
  }

  public void setGroupCode(String groupCode) {
    this.groupCode = groupCode;
  }

  public Long getUnitId() {
    return unitId;
  }

  public void setUnitId(Long unitId) {
    this.unitId = unitId;
  }

  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public void setItemDescription(String itemDescription) {
    this.itemDescription = itemDescription;
  }

  // public String getImageType() {
  //   return imageType;
  // }

  // public void setImageType(String imageType) {
  //   this.imageType = imageType;
  // }

  public String getPacking_type() {
    return packing_type;
  }

  public void setPacking_type(String packing_type) {
    this.packing_type = packing_type;
  }

  public String getItemCode() {
    return ItemCode;
  }

  public void setItemCode(String itemCode) {
    ItemCode = itemCode;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

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

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  // public String getImage() {
  //   return image;
  // }

  // public void setImage(String image) {
  //   this.image = image;
  // }

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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getStatus() {
    return Status;
  }

  public void setStatus(String status) {
    Status = status;
  }

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public Long getWeightId() {
    return weightId;
  }

  public void setWeightId(Long weightId) {
    this.weightId = weightId;
  }
}
