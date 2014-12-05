package com.conalytics.domain;


public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	
	private Double id;
	private String categoryCode;
	private String categoryDesc;
	private Double parentCategoryId;
	
	private static final long serialVersionUID = -6013600035254850771L;

	public Double getId() {
		return this.id;
	}
	public void setId(Double id) {
		this.id = id;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryDesc() {
		return this.categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public Double getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setParentCategoryId(Double parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}


}