package com.banking.beans;

public class Account 
{
	String customerId;
	String accountId;
	String accountType;
	int deposit;
	int balance;
	
	public  Account(String accountId2, String account_type, int balance2, String customerId2)
	{
		this.customerId = customerId2;
		this.accountId = accountId2;
		this.balance = balance2;
		this.accountType = account_type;
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
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public Account(String customerId, String accountType, int deposit) {
		super();
		this.customerId = customerId;
		this.accountType = accountType;
		this.deposit = deposit;
	}
	
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [customerId=" + customerId + ", accountId=" + accountId + ", accountType=" + accountType
				+ ", deposit=" + deposit + "]";
	}
	
	
	
	
	
}
