package com.conalytics.domain;


public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	
	private Double ID;
	private String CATEGORY_CODE;
	private String CATEGORY_DESC;
	private Double PARENT_CATEGORYID;
	
	private static final long serialVersionUID = -6013600035254850771L;

	public Double getID() {
		return ID;
	}
	public void setID(Double iD) {
		ID = iD;
	}
	public String getCATEGORY_CODE() {
		return CATEGORY_CODE;
	}
	public void setCATEGORY_CODE(String cATEGORY_CODE) {
		CATEGORY_CODE = cATEGORY_CODE;
	}
	public String getCATEGORY_DESC() {
		return CATEGORY_DESC;
	}
	public void setCATEGORY_DESC(String cATEGORY_DESC) {
		CATEGORY_DESC = cATEGORY_DESC;
	}
	public Double getPARENT_CATEGORYID() {
		return PARENT_CATEGORYID;
	}
	public void setPARENT_CATEGORYID(Double pARENT_CATEGORYID) {
		PARENT_CATEGORYID = pARENT_CATEGORYID;
	}


}