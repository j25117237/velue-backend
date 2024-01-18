package com.velue.dto;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  private Long customerId;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "customerId", insertable = false, updatable = false)
  private Customer customer;

  private String orderStatus;
  private String paymentMethod;
  private Long totalAmount;

  // @Column(name = "created_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
  // private LocalDateTime createdAt;
  // @Column(name = "updated_at", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
  // private LocalDateTime updatedAt;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt = new Date();

  @UpdateTimestamp
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  //	@UpdateTimestamp
  //	@Temporal(TemporalType.TIMESTAMP)
  //	@Column(name = "modify_date")
  //	private Date modifyDate;
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @OneToMany
  @JoinColumn(name = "order_id")
  public List<ItemProduct> product;

  @OneToMany
  @JoinColumn(name = "order_id")
  public List<Batch> batches;

  @OneToMany
  @JoinColumn(name = "order_id")
  public List<OrderBatch> orderBatches;

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public List<Batch> getBatches() {
    return batches;
  }

  public void setBatches(List<Batch> batches) {
    this.batches = batches;
  }

  public List<OrderBatch> getOrderBatches() {
    return orderBatches;
  }

  public void setOrderBatchs(List<OrderBatch> orderBatches) {
    this.orderBatches = orderBatches;
  }

  public List<ItemProduct> getProduct() {
    return product;
  }

  public void setProduct(List<ItemProduct> product) {
    this.product = product;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Long getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Long totalAmount) {
    this.totalAmount = totalAmount;
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

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }
  // public Order getOrder() {
  // return order;
  // }
  //
  // public void setOrder(Order order) {
  // this.order = order;
  // }

}
