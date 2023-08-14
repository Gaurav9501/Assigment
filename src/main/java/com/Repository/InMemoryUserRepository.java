package com.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.ExceptionHandling.UserAlreadyExistsException;
import com.ExceptionHandling.UserNotFoundException;
import com.Model.User;


public class InMemoryUserRepository implements UserRepository {
	
	private Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public void addUser(User user) throws UserAlreadyExistsException {
        if (users.containsKey(user.getName())) {
            throw new UserAlreadyExistsException("User already exists with the given name.");
        }
        users.put(user.getName(), user);
    }

    @Override
    public User getUser(String username) throws UserNotFoundException {
        User user = users.get(username);
        if (user == null) {
            throw new UserNotFoundException("User not found with the given name.");
        }
        return user;
    }
}
