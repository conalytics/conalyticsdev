package com.conalytics.domain;

public class City implements java.io.Serializable {

	private static final long serialVersionUID = -5789498193638676223L;

	private Double cityId;

	private String cityDesc;

	private String cityABB;

	private Double districtID;
	
	private String districtDesc;
	
	private Double stateID;
	
	private String stateDesc;
	
	private String zipCode;

	

	public City() {
	}



	public Double getCityId() {
		return cityId;
	}



	public void setCityId(Double cityId) {
		this.cityId = cityId;
	}



	public String getCityDesc() {
		return cityDesc;
	}



	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}



	public String getCityABB() {
		return cityABB;
	}



	public void setCityABB(String cityABB) {
		this.cityABB = cityABB;
	}



	public Double getDistrictID() {
		return districtID;
	}



	public void setDistrictID(Double districtID) {
		this.districtID = districtID;
	}



	public String getDistrictDesc() {
		return districtDesc;
	}



	public void setDistrictDesc(String districtDesc) {
		this.districtDesc = districtDesc;
	}



	public Double getStateID() {
		return stateID;
	}



	public void setStateID(Double stateID) {
		this.stateID = stateID;
	}



	public String getStateDesc() {
		return stateDesc;
	}



	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}



	public String getZipCode() {
		return zipCode;
	}



	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}



	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityDesc=" + cityDesc
				+ ", cityABB=" + cityABB + ", districtID=" + districtID
				+ ", districtDesc=" + districtDesc + ", stateID=" + stateID
				+ ", stateDesc=" + stateDesc + ", zipCode=" + zipCode + "]";
	}

}