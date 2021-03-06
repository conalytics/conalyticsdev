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
	private Double cost;
	private String shopName;
	private String address;
	private Double quantityav;
	private Double shPPU;
	private Double shRPU;
	private Double catId;
	
	public Double getCatId() {
		return catId;
	}
	public void setCatId(Double catId) {
		this.catId = catId;
	}
	public Double getQuantityav() {
		return quantityav;
	}
	public void setQuantityav(Double quantityav) {
		this.quantityav = quantityav;
	}
	public Double getShPPU() {
		return shPPU;
	}
	public void setShPPU(Double shPPU) {
		this.shPPU = shPPU;
	}
	public Double getShRPU() {
		return shRPU;
	}
	public void setShRPU(Double shRPU) {
		this.shRPU = shRPU;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

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