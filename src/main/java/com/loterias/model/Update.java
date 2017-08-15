package com.loterias.model;

public class Update {

	Boolean isUpdated;
	String updateDate;

	public Update() {
		this.updateDate = "";
		this.isUpdated = false;
	}

	public Update(Boolean isUpdated, String updateDate) {
		this.isUpdated = isUpdated;
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

	/**
	 * @return the isUpdated
	 */
	public Boolean getIsUpdated() {
		return isUpdated;
	}

	/**
	 * @param isUpdated the isUpdated to set
	 */
	public void setIsUpdated(Boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	
	
}
