package com.birdydex.beans;

public class TestingBeans {

	public static void main(String[] args) {
		BuilderBean bb = new BuilderBean();
		
		bb.setBirdName("Tweety");
		bb.setBirdSciName("Tweetacker");
		bb.setBirdDescription("Very FLUFFY!");
		bb.setBirdLocation("In your heart!");
		BirdBean tweet = bb.createBird();
		
		System.out.println("Bird name: " + tweet.getName());
		

	}

}
