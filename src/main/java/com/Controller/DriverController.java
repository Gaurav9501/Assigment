package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExceptionHandling.DriverAlreadyExistsException;
import com.Model.Driver;
import com.Service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

	private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<String> addDriver(@RequestBody Driver driver) {
        try {
            driverService.addDriver(driver);
            return ResponseEntity.ok("Driver added successfully.");
        } catch (DriverAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
