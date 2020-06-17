package com.banking.beans;

public class AccountStatus {
	
	String customerId;
	

	String accountId;
	
	String accountType;

	String status;

	String message;

	String lastUpdated;
	
	public AccountStatus()
	{
		
	}
	

	public AccountStatus(String customerId, String accountId, String accountType, String status, String message,
			String lastUpdated) {
		super();
		this.customerId = customerId;
		this.accountId = accountId;
		this.accountType = accountType;
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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
	
	

}
