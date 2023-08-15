package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExceptionHandling.NoAvailableRideException;
import com.ExceptionHandling.UserAlreadyExistsException;
import com.ExceptionHandling.UserNotFoundException;
import com.Model.Driver;
import com.Model.Location;
import com.Model.RideRequest;
import com.Model.User;
import com.Repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	  private final DriverService driverService;
    @Autowired
    public UserService(UserRepository userRepository,DriverService driverService) {
        this.userRepository = userRepository;
        this.driverService = driverService;
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        userRepository.addUser(user);
    }

    public User getUser(String username) throws UserNotFoundException {
        return userRepository.getUser(username);
    }
    
    public void bookRide(String username, RideRequest rideRequest)
            throws UserNotFoundException, NoAvailableRideException {
        User user = userRepository.getUser(username);
        List<Driver> availableDrivers = driverService.findRide(user, rideRequest.getSource(), rideRequest.getDestination());
        if (availableDrivers.isEmpty()) {
            throw new NoAvailableRideException("No ride available.");
        }

        Driver nearestDriver = findNearestDriver(rideRequest.getSource(), availableDrivers);

    }
    
    private Driver findNearestDriver(Location userLocation, List<Driver> drivers) {
        double minDistance = Double.MAX_VALUE;
        Driver nearestDriver = null;

        for (Driver driver : drivers) {
            double distance = calculateDistance(userLocation, driver.getCurrentLocation());
            if (distance < minDistance) {
                minDistance = distance;
                nearestDriver = driver;
            }
        }

        return nearestDriver;
    }
    private double calculateDistance(Location loc1, Location loc2) {
        return Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2));
    }
}
