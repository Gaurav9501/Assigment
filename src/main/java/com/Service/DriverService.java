package com.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExceptionHandling.DriverAlreadyExistsException;
import com.ExceptionHandling.DriverNotFoundException;
import com.ExceptionHandling.UserNotFoundException;
import com.Model.Driver;
import com.Model.Location;
import com.Model.User;
import com.Repository.DriverRepository;
import com.Repository.UserRepository;

@Service
public class DriverService {
	
	 private final DriverRepository driverRepository;

	 	@Autowired
	 	private UserRepository userRepository;
	    @Autowired
	    public DriverService(DriverRepository driverRepository) {
	        this.driverRepository = driverRepository;
	    }
	    
	    public void addDriver(Driver driver)
	            throws DriverAlreadyExistsException {
	        driverRepository.addDriver(driver);
	    }
	    
	    public List<Driver> findRide(User user, Location source, Location destination) throws UserNotFoundException {

	        List<Driver> availableDrivers = new ArrayList<>();
	        for (Driver driver : driverRepository.getAllDrivers()) {
	            if (driver.isAvailable() && calculateDistance(driver.getCurrentLocation(), source) <= 5) {
	                availableDrivers.add(driver);
	            }
	        }
	        return availableDrivers;
	    }
	    
	    private double calculateDistance(Location loc1, Location loc2) {
	        return Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2));
	    }
	    
	    public void updateDriver(String driverId, Driver updatedDriver) throws DriverNotFoundException {
	        Driver driver = driverRepository.getDriver(driverId);
	        driver.setName(updatedDriver.getName());
	        driver.setGender(updatedDriver.getGender());
	        driver.setAge(updatedDriver.getAge());
	        driver.setVehicleDetails(updatedDriver.getVehicleDetails());
	        driver.setCurrentLocation(updatedDriver.getCurrentLocation());
	        driver.setAvailable(updatedDriver.isAvailable());

	        try {
	            driverRepository.addDriver(driver);
	        } catch (DriverAlreadyExistsException e) {
	        }
	    }
}
