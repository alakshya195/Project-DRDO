package com.projectDRDO;

public class aircraftData {
	private int total_fatalities;
	private String date;

	private String aircraft;
	private String crash_location;
	private String country;
	
	
	public aircraftData(int total_fatalities, String date, String aircraft, String crash_location , String country) {
		super();
		this.total_fatalities = total_fatalities;
		this.date = date;
	
		this.aircraft = aircraft;
		this.crash_location = crash_location;
		this.country = country;
	}

	public int getTotal_fatalities() {
		return total_fatalities;
	}
	public void setTotal_fatalities(int total_fatalities) {
		this.total_fatalities = total_fatalities;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public String getCrash_location() {
		return crash_location;
	}
	public void setCrash_location(String crash_location) {
		this.crash_location = crash_location;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}	
}







