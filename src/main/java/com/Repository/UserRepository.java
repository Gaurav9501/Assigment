package com.Repository;

import org.springframework.stereotype.Repository;

import com.ExceptionHandling.UserAlreadyExistsException;
import com.ExceptionHandling.UserNotFoundException;
import com.Model.User;

	
public interface UserRepository {
	void addUser(User user) throws UserAlreadyExistsException;;
    User getUser(String username)throws UserNotFoundException ;
}