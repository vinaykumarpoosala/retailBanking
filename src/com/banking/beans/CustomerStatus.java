package com.banking.beans;

import java.sql.Timestamp;

public class CustomerStatus {

	String customerId;
	
	String ssnid;
	
	String status;
	
	String message;
	
	String lastUpdated;

	public CustomerStatus(String customerId, String ssnid, String status, String message, String lastUpdated) {
		super();
		this.customerId = customerId;
		this.ssnid = ssnid;
		this.status = status;
		this.message = message;
		this.lastUpdated = lastUpdated;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSsnid() {
		return ssnid;
	}

	public void setSsnid(String ssnid) {
		this.ssnid = ssnid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "CustomerStatus [customerId=" + customerId + ", ssnid=" + ssnid + ", status=" + status + ", message="
				+ message + ", lastUpdated=" + lastUpdated + "]";
	}
	
	
	
	
}
