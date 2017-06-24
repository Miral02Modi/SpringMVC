package com.bridgeit.PathVariable.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.PathVariable.dao.UserDao;
import com.bridgeit.PathVariable.model.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Override
	public boolean isValidUser(User user) {
		return userDao.isValidUser(user); 
	}

	@Override
	public void userRegister(User user) {
		userDao.userRegister(user);
	}

}
