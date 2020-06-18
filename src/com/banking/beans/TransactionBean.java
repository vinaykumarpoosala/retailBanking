package com.banking.beans;

public class TransactionBean
{
	
	String TID;
	String account_id;
	String account_type;
	int amount;
	String transactionDate;
	String transactionType;
	
	//default constructor
	
	public TransactionBean()
	{
		
	}
	
	public TransactionBean(String tID, String account_id, String account_type, int amount, String transactionDate,
			String transactionType) {
		super();
		TID = tID;
		this.account_id = account_id;
		this.account_type = account_type;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
	}
	
	
	public String getTID() {
		return TID;
	}
	public void setTID(String tID) {
		TID = tID;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	@Override
	public String toString() {
		return "TransactionBean [TID=" + TID + ", account_id=" + account_id + ", account_type=" + account_type
				+ ", amount=" + amount + ", transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ "]";
	}
	
	//okay??yes
	

}
