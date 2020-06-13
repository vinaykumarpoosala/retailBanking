package com.banking.beans;

public class Customer {
	int ssnid;
	String name;
	int age;
	String address;
	String state;
	String city;
	int deposit;
	int withdraw;

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
	public int getSsnid() {
		return ssnid;
	}
	public String getName() {
		return name;
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
	public void setSsnid(int ssnid) {
		this.ssnid = ssnid;
	}
	public void setName(String name) {
		this.name = name;
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

	public Customer(int ssnid, String name, int age, String address, String state, String city) {
		super();
		this.ssnid = ssnid;
		this.name = name;
		this.age = age;
		this.address = address;
		this.state = state;
		this.city = city;
	}

}
