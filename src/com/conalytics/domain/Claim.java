package com.conalytics.domain;

public class Claim implements java.io.Serializable {

	private static final long serialVersionUID = -5789498193638676223L;





	private Double claimId;
	
	private String VIN;
	
	private Double modelId;

	private String location;
	
	private String color;

	private String date;
	
	private String gclat;
	
	private String gclong;
	
	private String vinfo;
	








	public String getVinfo() {
		return vinfo;
	}


	public void setVinfo(String vinfo) {
		this.vinfo = vinfo;
	}


	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", VIN=" + VIN + ", modelId="
				+ modelId + ", location=" + location + ", color=" + color
				+ ", date=" + date + ", gclat=" + gclat + ", gclong=" + gclong
				+ ", Vehicle_info=" + vinfo + "]";
	}


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






	public String getLocation() {
		return location;
	}






	public void setLocation(String loc) {
		this.location = loc;
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




	
	}