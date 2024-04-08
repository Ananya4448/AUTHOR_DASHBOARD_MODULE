package com.springrest.springrest.services;

import com.springrest.springrest.bodyjson.LoginRequest;
import com.springrest.springrest.entities.User;

public interface UserService {
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public User updateUserWithoutPass(User user);
	
	public User getUser(LoginRequest loginRequest);
	
	public User getUserByEmail(String email);
}
