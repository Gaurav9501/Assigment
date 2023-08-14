package com.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ExceptionHandling.DriverAlreadyExistsException;
import com.ExceptionHandling.DriverNotFoundException;
import com.Model.Driver;

public class InMemoryDriverRepository implements DriverRepository {

	 private Map<String, Driver> drivers = new ConcurrentHashMap<>();

	    @Override
	    public void addDriver(Driver driver) throws DriverAlreadyExistsException {
	        if (drivers.containsKey(driver.getName())) {
	            throw new DriverAlreadyExistsException("Driver already exists with the given name.");
	        }
	        drivers.put(driver.getName(), driver);
	    }

	    @Override
	    public Driver getDriver(String driverName) throws DriverNotFoundException {
	        Driver driver = drivers.get(driverName);
	        if (driver == null) {
	            throw new DriverNotFoundException("Driver not found with the given name.");
	        }
	        return driver;
	    }
	    @Override
	    public List<Driver> getAllDrivers() {
	        return new ArrayList<>(drivers.values());
	    }
}
