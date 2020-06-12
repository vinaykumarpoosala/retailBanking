package com.beans;
/***
 * 
 * Class is Bank Employee details
 *
 */

public class emplinfo {
	
	String username;
	String password;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public emplinfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
