package com.birdydex.beans;

//==========================================
//This class is used to create a USER object
//==========================================

public class UserBean {

	//Private variables for creating user
	private String username;
	private String password;
	private String email;
	
	
	//================================
	//Getters and Setters for all variables
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//================================
	//================================
	//Constructors for UserBean
	public UserBean() {
		
	}
	
	public UserBean(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	//================================
}
