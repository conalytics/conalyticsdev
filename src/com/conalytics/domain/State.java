package com.conalytics.domain;

public class State implements java.io.Serializable {

	private static final long serialVersionUID = -5789498193638676223L;

	private Double id;

	private String stateDesc;

	private String stateABB;

	public State() {
	}

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", stateDesc=" + stateDesc + ", stateABB="
				+ stateABB + "]";
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public String getStateABB() {
		return stateABB;
	}

	public void setStateABB(String stateABB) {
		this.stateABB = stateABB;
	}



}