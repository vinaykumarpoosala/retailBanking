package com.banking.beans;

public class Customer {
	
	String customerId;
	
	String ssnid;
	String customername;
	int age;
	String address;
	String state;
	String city;
	int deposit;
	int withdraw;
	
	public Customer()
	{
		
	}

	public int getDeposit() {
		return deposit;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public String getSsnid() {
		return ssnid;
	}
	public String getCustomername() {
		return customername;
	}
	public int getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}
	public void setSsnid(String ssnid) {
		this.ssnid = ssnid;
	}
	public void setName(String customername) {
		this.customername = customername;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public Customer(String ssnid, String customername, int age, String address, String state, String city) {
		super();
		this.ssnid = ssnid;
		this.customername = customername;
		this.age = age;
		this.address = address;
		this.state = state;
		this.city = city;
	}

}
