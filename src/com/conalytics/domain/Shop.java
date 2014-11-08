package com.conalytics.domain;

public class Shop implements java.io.Serializable {

	private static final long serialVersionUID = -5310374918903718618L;
	private Double shopId;
	private Double cityId;
	private String townMuni;
	private String shopName;
	private String shopDesc;
	private String phoneNumber;
	private String website;
	private String email;
	private String address;
	private Double stdHrlyLaborRate;
	private String gclat;
	private String gclong;
	
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	private String distance;

	public String getGclat() {
		return gclat;
	}

	public void setGclat(String gclat) {
		this.gclat = gclat;
	}

	public String getGclong() {
		return gclong;
	}

	public void setGclong(String gclong) {
		this.gclong = gclong;
	}

	public Shop() {
	}

	public Double getShopId() {
		return shopId;
	}

	public void setShopId(Double shopId) {
		this.shopId = shopId;
	}

	public Double getCityId() {
		return cityId;
	}

	public void setCityId(Double cityId) {
		this.cityId = cityId;
	}

	public String getTownMuni() {
		return townMuni;
	}

	public void setTownMuni(String townMuni) {
		this.townMuni = townMuni;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getStdHrlyLaborRate() {
		return stdHrlyLaborRate;
	}

	public void setStdHrlyLaborRate(Double stdHrlyLaborRate) {
		this.stdHrlyLaborRate = stdHrlyLaborRate;
	}

}