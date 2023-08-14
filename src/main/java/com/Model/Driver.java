package com.Model;

public class Driver {

	private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private Location currentLocation;
    private boolean available;
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Driver(String name, String gender, int age, String vehicleDetails, Location currentLocation,
			boolean available) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.vehicleDetails = vehicleDetails;
		this.currentLocation = currentLocation;
		this.available = available;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVehicleDetails() {
		return vehicleDetails;
	}
	public void setVehicleDetails(String vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	public Location getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Location currentLocation) {
		this.currentLocation = currentLocation;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
    
    
    
}
