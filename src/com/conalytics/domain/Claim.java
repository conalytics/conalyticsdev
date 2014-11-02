package com.conalytics.domain;

public class Claim implements java.io.Serializable {

	private static final long serialVersionUID = -5789498193638676223L;





	private Double claimId;
	
	private String VIN;
	
	private Double modelId;

	private Double shopId;
	
	private String color;

	private String date;
	



	public String getVIN() {
		return VIN;
	}


	public void setVIN(String vIN) {
		VIN = vIN;
	}



	

	public Claim() {
	}

	
	public Double getClaimId() {
		return claimId;
	}






	public void setClaimId(Double claimId) {
		this.claimId = claimId;
	}






	public Double getModelId() {
		return modelId;
	}






	public void setModelId(Double modelId) {
		this.modelId = modelId;
	}






	public Double getShopId() {
		return shopId;
	}






	public void setShopId(Double shopId) {
		this.shopId = shopId;
	}






	public String getColor() {
		return color;
	}






	public void setColor(String color) {
		this.color = color;
	}






	public String getDate() {
		return date;
	}






	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", VIN=" + VIN + ", modelId="
				+ modelId + ", shopId=" + shopId + ", color=" + color
				+ ", date=" + date + "]";
	}






}