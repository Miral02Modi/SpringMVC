package com.bridgeit.PathVariable.dao;

import com.bridgeit.PathVariable.model.User;

public interface UserDao {
	
	boolean isValidUser(User user);
	
	void userRegister(User user);
}
