package com.velue.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Bank {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bankId;

  @Column(length = 1000)
  private String bankName;

  @Column(length = 5000)
  private String bankDescription;

  public Long getBankId() {
    return bankId;
  }

  public void setBankId(Long bankId) {
    this.bankId = bankId;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBankDescription() {
    return bankDescription;
  }

  public void setBankDescription(String bankDescription) {
    this.bankDescription = bankDescription;
  }
}
