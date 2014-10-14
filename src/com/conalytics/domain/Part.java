package com.conalytics.domain;

public class Part implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6013600035254850771L;

	private Double partId;
	
	private Double autoId;

	private String partName;

	private String partDesc;

	private String model;

	private String version;
	
	private Double yearBuilt;
	
	private String oemNumber;
	
	private String color;
	
	private Double msrp;
	
	private Part selectedPart = null;
	public Part getSelectedPart(){
		 return this.selectedPart;
		}

		public void setSelectedPart(Part newSelectedPart){
		this.selectedPart=newSelectedPart;
		}

	

	public Part() {
	}

	

	public Double getPartId() {
		return partId;
	}



	public void setPartId(Double partId) {
		this.partId = partId;
	}



	public Double getAutoId() {
		return autoId;
	}



	public void setAutoId(Double autoId) {
		this.autoId = autoId;
	}



	public String getPartName() {
		return partName;
	}



	public void setPartName(String partName) {
		this.partName = partName;
	}



	public String getPartDesc() {
		return partDesc;
	}



	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
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



	public String getOemNumber() {
		return oemNumber;
	}



	public void setOemNumber(String oemNumber) {
		this.oemNumber = oemNumber;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Double getMsrp() {
		return msrp;
	}



	public void setMsrp(Double msrp) {
		this.msrp = msrp;
	}



	@Override
	public String toString() {
		return "Part [partCode=" + partDesc + ", partId=" + partId
				+ ", partName=" + partName + "]";
	}
}