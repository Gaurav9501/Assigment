package com.Model;

public class Ride {

	private User user;
    private Driver driver;
    private Location source;
    private Location destination;
	public Ride() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ride(User user, Driver driver, Location source, Location destination) {
		super();
		this.user = user;
		this.driver = driver;
		this.source = source;
		this.destination = destination;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Location getSource() {
		return source;
	}
	public void setSource(Location source) {
		this.source = source;
	}
	public Location getDestination() {
		return destination;
	}
	public void setDestination(Location destination) {
		this.destination = destination;
	}
    
    
    
}
