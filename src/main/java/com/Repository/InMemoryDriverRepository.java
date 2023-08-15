package com.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.ExceptionHandling.DriverAlreadyExistsException;
import com.ExceptionHandling.DriverNotFoundException;
import com.Model.Driver;

@Repository
public class InMemoryDriverRepository implements DriverRepository {

	    private Map<String, Driver> drivers = new ConcurrentHashMap<>();

	    @Override
	    public void addDriver(Driver driver) throws DriverAlreadyExistsException {
	        if (drivers.containsKey(driver.getDriverId())) {
	            throw new DriverAlreadyExistsException("Driver already exists with the given ID.");
	        }
	        drivers.put(driver.getDriverId(), driver);
	    }

	    @Override
	    public Driver getDriver(String driverId) throws DriverNotFoundException {
	        Driver driver = drivers.get(driverId);
	        if (driver == null) {
	            throw new DriverNotFoundException("Driver not found with the given ID.");
	        }
	        return driver;
	    }

	    @Override
	    public List<Driver> getAllDrivers() {
	        return new ArrayList<>(drivers.values());
	    }
	}
