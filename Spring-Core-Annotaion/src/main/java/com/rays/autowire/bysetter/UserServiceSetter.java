package com.rays.autowire.bysetter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserServiceSetter {

	private UserDAOInt userDao;
	
	@Autowired
	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}
	
	public void add() {
		userDao.add();
	}
}
