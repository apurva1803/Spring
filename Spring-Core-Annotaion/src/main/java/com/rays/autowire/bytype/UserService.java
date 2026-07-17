package com.rays.autowire.bytype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userServiceT")
public class UserService {

	@Autowired
	private UserDAOInt userDao;
	
	public void add() {
		userDao.add();
	}
}
