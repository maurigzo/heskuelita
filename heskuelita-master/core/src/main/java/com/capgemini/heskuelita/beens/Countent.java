package com.capgemini.heskuelita.beens;

public class Countent {

	private String name_Countent;
	private String description;
	private int Time_Duration;

	public Countent(){}
	public Countent(String name_Countent, String description, int time_Duration) {
		super();
		this.name_Countent = name_Countent;
		this.description = description;
		Time_Duration = time_Duration;
	}

	//Getters and Setters
	public String getName_Countent() {
		return name_Countent;
	}
	public void setName_Countent(String name_Countent) {
		this.name_Countent = name_Countent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTime_Duration() {
		return Time_Duration;
	}
	public void setTime_Duration(int time_Duration) {
		Time_Duration = time_Duration;
	}



}