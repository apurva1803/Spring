package com.rays.autowire.byconstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceConstructor {

	
	private UserDAOInt userDao;
	
	@Autowired
	public UserServiceConstructor(UserDAOInt userDao) {
		this.userDao = userDao;
	}
	
	public void add() {
		userDao.add();
	}
}
