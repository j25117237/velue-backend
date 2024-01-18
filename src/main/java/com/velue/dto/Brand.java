package com.velue.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Brand {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long brandId;

  @Column(length = 1000)
  private String brandName;

  @Column(length = 5000)
  private String brandDesc;

  private String imageName;

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
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

  public String getBrandDesc() {
    return brandDesc;
  }

  public void setBrandDesc(String brandDesc) {
    this.brandDesc = brandDesc;
  }
}
