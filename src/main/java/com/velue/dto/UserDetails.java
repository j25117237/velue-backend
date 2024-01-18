package com.velue.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;

  private String firstName;
  private String lastName;
  private String emailAddress;
  private String mobileNumber;
  private String birthDate;
  private String gender;
  private String emergencyContactName;
  private String emergencyContactNumber;
  private String status;
  private String dateOfJoining;
  private String password;

  private String profileImageName;
  private String panImageName;
  private String aadharImageName;

  private Long roleId;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "roleId", insertable = false, updatable = false)
  private Role roleDetails;

  public Role getRoleDetails() {
    return roleDetails;
  }

  public void setRoleDetails(Role roleDetails) {
    this.roleDetails = roleDetails;
  }

  private long empReferenceId;

  // @Transient
  // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  // @JoinColumn(name = "empReferenceId", insertable = false, updatable = false)
  // private UserSalaryDetails userSalary;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "empReferenceId", insertable = false, updatable = false)
  private UserSalaryDetails userSalaryDetails;

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getEmergencyContactName() {
    return emergencyContactName;
  }

  public void setEmergencyContactName(String emergencyContactName) {
    this.emergencyContactName = emergencyContactName;
  }

  public String getEmergencyContactNumber() {
    return emergencyContactNumber;
  }

  public void setEmergencyContactNumber(String emergencyContactNumber) {
    this.emergencyContactNumber = emergencyContactNumber;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(String dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserSalaryDetails getUserSalaryDetails() {
    return userSalaryDetails;
  }

  public void setUserSalaryDetails(UserSalaryDetails userSalary) {
    this.userSalaryDetails = userSalary;
  }

  public long getEmpReferenceId() {
    return empReferenceId;
  }

  public void setEmpReferenceId(long empReferenceId) {
    this.empReferenceId = empReferenceId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getProfileImageName() {
    return profileImageName;
  }

  public void setProfileImageName(String profileImageName) {
    this.profileImageName = profileImageName;
  }

  public String getPanImageName() {
    return panImageName;
  }

  public void setPanImageName(String panImageName) {
    this.panImageName = panImageName;
  }

  public String getAadharImageName() {
    return aadharImageName;
  }

  public void setAadharImageName(String aadharImageName) {
    this.aadharImageName = aadharImageName;
  }
}
