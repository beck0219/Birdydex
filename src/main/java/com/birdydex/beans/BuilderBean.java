package com.birdydex.beans;

public class BuilderBean {
    //Private variables for creating bird
    private String name;
    private String sciName; //Scientific name
    private String location;
    private String description;

    public BuilderBean() {
    }

    public BuilderBean setBirdName(String name) {
    	this.name = name;
    	return this;
    }
    
    public BuilderBean setBirdSciName(String sciName) {
        this.sciName = sciName;
        return this;
    }

    public BuilderBean setBirdLocation(String location) {
        this.location = location;
        return this;
    }

    public BuilderBean setBirdDescription(String description) {
        this.description = description;
        return this;
    }

    public BuilderBean(String name, String sciName, String location, String description) {
        this.name = name;
        this.sciName = sciName;
        this.location = location;
        this.description = description;
    }
    
    
    public BirdBean createBird() {
    	return new BirdBean(name, sciName, location, description);
    }


}