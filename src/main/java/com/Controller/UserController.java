package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ExceptionHandling.UserAlreadyExistsException;
import com.Model.User;
import com.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("User added successfully.");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
