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
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "batch")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Batch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long batchId;

  @Column(length = 1000)
  private String batchNumber;

  @Column(name = "order_id")
  private long orderId;

  private String status;
  private String customerName;

  private long invoiceAmount;

  public long getInvoiceAmount() {
    return invoiceAmount;
  }

  public void setInvoiceAmount(long invoiceAmount) {
    this.invoiceAmount = invoiceAmount;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Long getBatchId() {
    return batchId;
  }

  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt = new Date();

  @UpdateTimestamp
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

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
}
