package com.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ExceptionHandling.DriverAlreadyExistsException;
import com.ExceptionHandling.DriverNotFoundException;
import com.Model.Driver;


public interface DriverRepository {
    void addDriver(Driver driver) throws DriverAlreadyExistsException;;
    Driver getDriver(String driverName) throws DriverNotFoundException;;
    List<Driver> getAllDrivers();
}
