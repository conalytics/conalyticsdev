package com.conalytics.domain;

import java.sql.Blob;



public class Inventory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6013600035254850771L;

	private double SHOP_PART_ID;
	private double SHOP_ID;
	private double PART_ID	;
	private double QTY_AVAILABLE;
	private double PRICE_PER_UNIT;
	private double RTL_PRICE_PER_UNIT;
	private double STD_HRLY_PART_LABOR_RATE;
	private Blob image;
		//non table data
	private String distance;
	private String shopdesc;
	
	


	public String getShopdesc() {
		return shopdesc;
	}
	public void setShopdesc(String shopdesc) {
		this.shopdesc = shopdesc;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public double getSHOP_PART_ID() {
		return SHOP_PART_ID;
	}
	public void setSHOP_PART_ID(double sHOP_PART_ID) {
		SHOP_PART_ID = sHOP_PART_ID;
	}
	public double getSHOP_ID() {
		return SHOP_ID;
	}
	public void setSHOP_ID(double sHOP_ID) {
		SHOP_ID = sHOP_ID;
	}
	public double getPART_ID() {
		return PART_ID;
	}
	public void setPART_ID(double pART_ID) {
		PART_ID = pART_ID;
	}
	public double getQTY_AVAILABLE() {
		return QTY_AVAILABLE;
	}
	public void setQTY_AVAILABLE(double qTY_AVAILABLE) {
		QTY_AVAILABLE = qTY_AVAILABLE;
	}
	public double getPRICE_PER_UNIT() {
		return PRICE_PER_UNIT;
	}

	public void setPRICE_PER_UNIT(double pRICE_PER_UNIT) {
		PRICE_PER_UNIT = pRICE_PER_UNIT;
	}
	public double getRTL_PRICE_PER_UNIT() {
		return RTL_PRICE_PER_UNIT;
	}
	public void setRTL_PRICE_PER_UNIT(double rTL_PRICE_PER_UNIT) {
		RTL_PRICE_PER_UNIT = rTL_PRICE_PER_UNIT;
	}
	public double getSTD_HRLY_PART_LABOR_RATE() {
		return STD_HRLY_PART_LABOR_RATE;
	}
	public void setSTD_HRLY_PART_LABOR_RATE(double sTD_HRLY_PART_LABOR_RATE) {
		STD_HRLY_PART_LABOR_RATE = sTD_HRLY_PART_LABOR_RATE;
	}
	
	@Override
	public String toString() {
		return "Inventory [SHOP_PART_ID=" + SHOP_PART_ID + ", SHOP_ID="
				+ SHOP_ID + ", PART_ID=" + PART_ID + ", QTY_AVAILABLE="
				+ QTY_AVAILABLE + ", PRICE_PER_UNIT=" + PRICE_PER_UNIT
				+ ", RTL_PRICE_PER_UNIT=" + RTL_PRICE_PER_UNIT
				+ ", STD_HRLY_PART_LABOR_RATE=" + STD_HRLY_PART_LABOR_RATE
				+ "]";
	}
	
}