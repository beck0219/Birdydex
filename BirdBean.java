package com.birdydex.beans;

//==========================================
//This class is used to create a BIRD object
//==========================================

public class BirdBean {
	
	//Private variables for creating bird
	private String name;
	private String sciName;
	private String location;
	private String description;
	
	//================================
	//Getters and Setters for all variables
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSciName() {
		return sciName;
	}
	public void setSciName(String sciName) {
		this.sciName = sciName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//================================
	//================================
	//Constructors for BirdBean
	public BirdBean() {

	//BirdBean Test Comment
		
	}
	
	public BirdBean(String name, String sciName, String location, String description) {
		this.name = name;
		this.sciName = sciName;
		this.location = location;
		this.description = description;
	}
	//================================

}
