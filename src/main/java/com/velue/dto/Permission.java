package com.velue.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "permission")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Permission {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long permissionId;

  private String permissionName;
  private boolean viewDashboard;
  private boolean createProduct;
  private boolean viewProduct;
  private boolean editProduct;
  private boolean deleteProduct;
  private boolean disableProduct;
  private boolean viewOrder;
  private boolean createOrder;
  private boolean deleteOrder;
  private boolean editOrder;
  private boolean acceptOrder;
  private boolean approveOrder;
  private boolean intransitOrder;
  private boolean deliverOrder;
  private boolean viewUser;
  private boolean createUser;
  private boolean editUser;
  private boolean disableUser;
  private boolean viewCustomer;
  private boolean createCustomer;
  private boolean editCustomer;
  private boolean disableCustomer;
  private boolean viewReport;
  private boolean viewMasterdata;
  private boolean addMasterdata;
  private boolean editMasterdata;
  private boolean deleteMasterdata;

  public boolean isViewDashboard() {
    return viewDashboard;
  }

  public void setViewDashboard(boolean viewDashboard) {
    this.viewDashboard = viewDashboard;
  }

  public boolean isCreateProduct() {
    return createProduct;
  }

  public void setCreateProduct(boolean createProduct) {
    this.createProduct = createProduct;
  }

  public boolean isViewProduct() {
    return viewProduct;
  }

  public void setViewProduct(boolean viewProduct) {
    this.viewProduct = viewProduct;
  }

  public boolean isEditProduct() {
    return editProduct;
  }

  public void setEditProduct(boolean editProduct) {
    this.editProduct = editProduct;
  }

  public boolean isDeleteProduct() {
    return deleteProduct;
  }

  public void setDeleteProduct(boolean deleteProduct) {
    this.deleteProduct = deleteProduct;
  }

  public boolean isDisableProduct() {
    return disableProduct;
  }

  public void setDisableProduct(boolean disableProduct) {
    this.disableProduct = disableProduct;
  }

  public boolean isViewOrder() {
    return viewOrder;
  }

  public void setViewOrder(boolean viewOrder) {
    this.viewOrder = viewOrder;
  }

  public boolean isCreateOrder() {
    return createOrder;
  }

  public void setCreateOrder(boolean createOrder) {
    this.createOrder = createOrder;
  }

  public boolean isDeleteOrder() {
    return deleteOrder;
  }

  public void setDeleteOrder(boolean deleteOrder) {
    this.deleteOrder = deleteOrder;
  }

  public boolean isEditOrder() {
    return editOrder;
  }

  public void setEditOrder(boolean editOrder) {
    this.editOrder = editOrder;
  }

  public boolean isAcceptOrder() {
    return acceptOrder;
  }

  public void setAcceptOrder(boolean acceptOrder) {
    this.acceptOrder = acceptOrder;
  }

  public boolean isApproveOrder() {
    return approveOrder;
  }

  public void setApproveOrder(boolean approveOrder) {
    this.approveOrder = approveOrder;
  }

  public boolean isIntransitOrder() {
    return intransitOrder;
  }

  public void setIntransitOrder(boolean intransitOrder) {
    this.intransitOrder = intransitOrder;
  }

  public boolean isDeliverOrder() {
    return deliverOrder;
  }

  public void setDeliverOrder(boolean deliverOrder) {
    this.deliverOrder = deliverOrder;
  }

  public boolean isViewUser() {
    return viewUser;
  }

  public void setViewUser(boolean viewUser) {
    this.viewUser = viewUser;
  }

  public boolean isCreateUser() {
    return createUser;
  }

  public void setCreateUser(boolean createUser) {
    this.createUser = createUser;
  }

  public boolean isEditUser() {
    return editUser;
  }

  public void setEditUser(boolean editUser) {
    this.editUser = editUser;
  }

  public boolean isDisableUser() {
    return disableUser;
  }

  public void setDisableUser(boolean disableUser) {
    this.disableUser = disableUser;
  }

  public boolean isViewCustomer() {
    return viewCustomer;
  }

  public void setViewCustomer(boolean viewCustomer) {
    this.viewCustomer = viewCustomer;
  }

  public boolean isCreateCustomer() {
    return createCustomer;
  }

  public void setCreateCustomer(boolean createCustomer) {
    this.createCustomer = createCustomer;
  }

  public boolean isEditCustomer() {
    return editCustomer;
  }

  public void setEditCustomer(boolean editCustomer) {
    this.editCustomer = editCustomer;
  }

  public boolean isDisableCustomer() {
    return disableCustomer;
  }

  public void setDisableCustomer(boolean disableCustomer) {
    this.disableCustomer = disableCustomer;
  }

  public boolean isViewReport() {
    return viewReport;
  }

  public void setViewReport(boolean viewReport) {
    this.viewReport = viewReport;
  }

  public boolean isViewMasterdata() {
    return viewMasterdata;
  }

  public void setViewMasterdata(boolean viewMasterdata) {
    this.viewMasterdata = viewMasterdata;
  }

  public boolean isAddMasterdata() {
    return addMasterdata;
  }

  public void setAddMasterdata(boolean addMasterdata) {
    this.addMasterdata = addMasterdata;
  }

  public boolean isEditMasterdata() {
    return editMasterdata;
  }

  public void setEditMasterdata(boolean editMasterdata) {
    this.editMasterdata = editMasterdata;
  }

  public boolean isDeleteMasterdata() {
    return deleteMasterdata;
  }

  public void setDeleteMasterdata(boolean deleteMasterdata) {
    this.deleteMasterdata = deleteMasterdata;
  }

  public Long getPermissionId() {
    return permissionId;
  }

  public void setPermissionId(Long permissionId) {
    this.permissionId = permissionId;
  }

  public String getPermissionName() {
    return permissionName;
  }

  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName;
  }
}
