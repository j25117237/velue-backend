package com.velue.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "customer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;

  private String customerName;
  private String contactName;
  private String primaryNumber;
  private String whatsAppNumber;
  private String contactGmail;
  private long creditLimitAmount;
  private int creditLimitDays;
  private long outstandingLimit;
  private long overdue;
  private String gstno;

  @Basic(optional = false)
  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt = new Date(); // initialize created date

  @UpdateTimestamp
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  // @Column(name = "customer_bank_bank_reference_id", insertable = false,
  // updatable = false)
  private long bankReferenceId;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
  @JoinColumn(name = "bankReferenceId", insertable = false, updatable = false)
  private CustomerBankDetails customerBank;

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getGstno() {
    return gstno;
  }

  public void setGstno(String gstno) {
    this.gstno = gstno;
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

  public Customer() {
    // TODO Auto-generated constructor stub
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getPrimaryNumber() {
    return primaryNumber;
  }

  public void setPrimaryNumber(String primaryNumber) {
    this.primaryNumber = primaryNumber;
  }

  public String getWhatsAppNumber() {
    return whatsAppNumber;
  }

  public void setWhatsAppNumber(String whatsAppNumber) {
    this.whatsAppNumber = whatsAppNumber;
  }

  public String getContactGmail() {
    return contactGmail;
  }

  public void setContactGmail(String contactGmail) {
    this.contactGmail = contactGmail;
  }

  public long getCreditLimitAmount() {
    return creditLimitAmount;
  }

  public void setCreditLimitAmount(long creditLimitAmount) {
    this.creditLimitAmount = creditLimitAmount;
  }

  public int getCreditLimitDays() {
    return creditLimitDays;
  }

  public void setCreditLimitDays(int creditLimitDays) {
    this.creditLimitDays = creditLimitDays;
  }

  public long getBankReferenceId() {
    return bankReferenceId;
  }

  public void setBankReferenceId(long bankReferenceId) {
    this.bankReferenceId = bankReferenceId;
  }

  public CustomerBankDetails getCustomerBank() {
    return customerBank;
  }

  public void setCustomerBank(CustomerBankDetails customerBank) {
    this.customerBank = customerBank;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setOutstandingLimit(long outstandingLimitAmount) {
    this.outstandingLimit = outstandingLimitAmount;
  }

  public long getOutstandingLimit() {
    return outstandingLimit;
  }

  public void setOverdue(long overdue) {
    this.overdue = overdue;
  }

  public long getOverdue() {
    return overdue;
  }

  public Customer(
    Long customerId,
    String customerName,
    String contactName,
    String primaryNumber,
    String gstno
  ) {
    super();
    this.customerId = customerId;
    this.customerName = customerName;
    this.contactName = contactName;
    this.primaryNumber = primaryNumber;
    this.gstno = gstno;
  }
}
