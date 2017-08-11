package com.loterias.model;

public class Update {

	String updateDate;

	public Update() {
		this.updateDate = "";
	}

	public Update(String updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
