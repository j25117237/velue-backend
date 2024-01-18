package com.velue.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserSalaryDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_reference_id")
  private long empReferenceId;

  private String accountDetails;
  private String bankName;
  private String ifscCode;
  private double salaryPerMonth;
  private String panCardNumber;
  private String aadharCardNumber;

  public String getAccountDetails() {
    return accountDetails;
  }

  public void setAccountDetails(String accountDetails) {
    this.accountDetails = accountDetails;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getIfscCode() {
    return ifscCode;
  }

  public void setIfscCode(String ifscCode) {
    this.ifscCode = ifscCode;
  }

  public double getSalaryPerMonth() {
    return salaryPerMonth;
  }

  public void setSalaryPerMonth(double salaryPerMonth) {
    this.salaryPerMonth = salaryPerMonth;
  }

  public String getPanCardNumber() {
    return panCardNumber;
  }

  public void setPanCardNumber(String panCardNumber) {
    this.panCardNumber = panCardNumber;
  }

  public String getAadharCardNumber() {
    return aadharCardNumber;
  }

  public void setAadharCardNumber(String aadharCardNumber) {
    this.aadharCardNumber = aadharCardNumber;
  }

  public long getEmpReferenceId() {
    return empReferenceId;
  }

  public void setEmpReferenceId(long empReferenceId) {
    this.empReferenceId = empReferenceId;
  }
}
