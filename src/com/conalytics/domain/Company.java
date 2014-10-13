package com.conalytics.domain;

public class Company implements java.io.Serializable {

	private static final long serialVersionUID = -5789498193638676223L;

	private Double companyId;

	private String companyName;

	private String companyDesc;

	private String phoneNumber;

	private String websiteAddress;
	
	private String emailId;
	
	private String address;

	

	public Company() {
	}

	public Double getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Double companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDesc() {
		return this.companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsiteAddress() {
		return websiteAddress;
	}

	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [companyCode=" + companyDesc + ", companyId=" + companyId
				+ ", companyName=" + companyName + "]";
	}
}