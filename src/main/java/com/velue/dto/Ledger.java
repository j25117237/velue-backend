package com.velue.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ledger")
public class Ledger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long ledgerId;
	@Column(name = "LedgerName")
	private String ledgerName ;
	@Column(name = "LedgerMailName")
	private String ledgerMailName ;
	@Column(name = "LedParent")
	private String ledParent ;
	@Column(name = "ledMainParent")
	private String ledMainParent ;
	@Column(name = "Masterid")
	private String masterid ;
	@Column(name = "alterid")
	private String alterid ;
	@Column(name = "ADDRESS1")
	private String address1 ;
	@Column(name = "ADDRESS2")
	private String address2 ;
	@Column(name = "ADDRESS3")
	private String address3 ;
	@Column(name = "ADDRESS4")
	private String address4 ;
	@Column(name = "State")
	private String state ;
	@Column(name = "PinCode")
	private String pinCode ;
	@Column(name = "PArtyGSTIN")
	private String partyGSTIN ;
	@Column(name = "GstRegType")
	private String gstRegType ;
	@Column(name = "LedgerContact")
	private String ledgerContact ;
	@Column(name = "Email")
	private String email ;
	@Column(name = "LedgerMobile")
	private String ledgerMobile ;
	@Column(name = "LedgerPhone")
	private String ledgerPhone ;
	@Column(name = "status")
	private String status ;
	public Long getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(Long ledgerId) {
		this.ledgerId = ledgerId;
	}
	public String getLedgerName() {
		return ledgerName;
	}
	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}
	public String getLedgerMailName() {
		return ledgerMailName;
	}
	public void setLedgerMailName(String ledgerMailName) {
		this.ledgerMailName = ledgerMailName;
	}
	public String getLedParent() {
		return ledParent;
	}
	public void setLedParent(String ledParent) {
		this.ledParent = ledParent;
	}
	public String getLedMainParent() {
		return ledMainParent;
	}
	public void setLedMainParent(String ledMainParent) {
		this.ledMainParent = ledMainParent;
	}
	public String getMasterid() {
		return masterid;
	}
	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}
	public String getAlterid() {
		return alterid;
	}
	public void setAlterid(String alterid) {
		this.alterid = alterid;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getAddress4() {
		return address4;
	}
	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getPartyGSTIN() {
		return partyGSTIN;
	}
	public void setPartyGSTIN(String partyGSTIN) {
		this.partyGSTIN = partyGSTIN;
	}
	public String getGstRegType() {
		return gstRegType;
	}
	public void setGstRegType(String gstRegType) {
		this.gstRegType = gstRegType;
	}
	public String getLedgerContact() {
		return ledgerContact;
	}
	public void setLedgerContact(String ledgerContact) {
		this.ledgerContact = ledgerContact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLedgerMobile() {
		return ledgerMobile;
	}
	public void setLedgerMobile(String ledgerMobile) {
		this.ledgerMobile = ledgerMobile;
	}
	public String getLedgerPhone() {
		return ledgerPhone;
	}
	public void setLedgerPhone(String ledgerPhone) {
		this.ledgerPhone = ledgerPhone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}




}
