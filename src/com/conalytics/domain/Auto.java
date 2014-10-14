package com.conalytics.domain;

public class Auto implements java.io.Serializable {

	private static final long serialVersionUID = 3612208079071391244L;
	private Double autoId;

	private Double companyId;
	
	private String companyName;

	private String autoName;

	private String autoDesc;

	private String model;

	private String version;

	private Double yearBuilt;

	public Auto() {
	}

	public Auto(String autoDesc, String autoName) {
		this.autoDesc = autoDesc;
		this.autoName = autoName;
	}

	public Double getAutoId() {
		return this.autoId;
	}

	public void setAutoId(Double autoId) {
		this.autoId = autoId;
	}

	public Double getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Double companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAutoName() {
		return this.autoName;
	}

	public void setAutoName(String autoName) {
		this.autoName = autoName;
	}

	public String getAutoDesc() {
		return this.autoDesc;
	}

	public void setAutoDesc(String autoDesc) {
		this.autoDesc = autoDesc;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Double getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(Double yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	@Override
	public String toString() {
		return "Auto [autoCode=" + autoDesc + ", autoId=" + autoId
				+ ", autoName=" + autoName + "]";
	}
}