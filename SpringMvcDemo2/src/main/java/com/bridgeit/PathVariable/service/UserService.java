package com.bridgeit.PathVariable.service;

import com.bridgeit.PathVariable.model.User;

public interface UserService {
	
	public boolean isValidUser(User user);
	
	public void userRegister(User user);
}
