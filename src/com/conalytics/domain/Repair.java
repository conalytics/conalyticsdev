package com.conalytics.domain;

public class Repair implements java.io.Serializable {

	private static final long serialVersionUID = -5789498193638676223L;




    private Double repairId;
	private String repairDesc;
	private Double claimId;
	private Double partId;
	private String partDesc;
	private Double quantity;
	private Double shopid;

	public Double getShopid() {
		return shopid;
	}
	public void setShopid(Double shopid) {
		this.shopid = shopid;
	}
	public Double getRepairId() {
		return repairId;
	}
	public void setRepairId(Double repairId) {
		this.repairId = repairId;
	}
	public Double getClaimId() {
		return claimId;
	}
	public void setClaimId(Double claimId) {
		this.claimId = claimId;
	}
	public Double getPartId() {
		return partId;
	}
	public void setPartId(Double partId) {
		this.partId = partId;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getPartDesc() {
		return partDesc;
	}
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}
	public String getRepairDesc() {
		return repairDesc;
	}
	public void setRepairDesc(String repairDesc) {
		this.repairDesc = repairDesc;
	}
	@Override
	public String toString() {
		return "Repair [repairId=" + repairId + ", claimId=" + claimId
				+ ", partId=" + partId + ", quantity=" + quantity
				+ ", partDesc=" + partDesc + ", repairDesc=" + repairDesc + "]";
	}
	
	
	
	
	


}