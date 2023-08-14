package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ExceptionHandling.UserAlreadyExistsException;
import com.ExceptionHandling.UserNotFoundException;
import com.Model.User;
import com.Repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) throws UserAlreadyExistsException {
        userRepository.addUser(user);
    }

    public User getUser(String username) throws UserNotFoundException {
        return userRepository.getUser(username);
    }
}
