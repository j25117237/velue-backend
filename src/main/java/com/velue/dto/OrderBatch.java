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
@Table(name = "orderbatch")
public class OrderBatch {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderBatchId;

  @Column(name = "order_id")
  private Long orderId;

  private Long batchId;
  private Long orderProductId;
  private Long productId;
  private Long dispatchQuantity;
  private Long invoiceAmount;

  public Long getInvoiceAmount() {
    return invoiceAmount;
  }

  public void setInvoiceAmount(Long invoiceAmount) {
    this.invoiceAmount = invoiceAmount;
  }

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt = new Date();

  @UpdateTimestamp
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  public Long getOrderBatchId() {
    return orderBatchId;
  }

  public void setOrderBatchId(Long orderBatchId) {
    this.orderBatchId = orderBatchId;
  }

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

  public Long getDispatchQuantity() {
    return dispatchQuantity;
  }

  public void setDispatchQuantity(Long dispatchQuantity) {
    this.dispatchQuantity = dispatchQuantity;
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

  public Long getBatchId() {
    return batchId;
  }

  public void setBatchId(Long batchId) {
    this.batchId = batchId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }
}
