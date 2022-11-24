package com.birdydex.beans;


public class BirdBean {
    private final String name;
    private final String sciName;
    private final String location;
    private final String description;

    public BirdBean(String name, String sciName, String location, String description) {
        this.name = name;
        this.sciName = sciName;
        this.location = location;
        this.description = description;
    }
    

	public String getName() {
		return name;
	}

	public String getSciName() {
		return sciName;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

}