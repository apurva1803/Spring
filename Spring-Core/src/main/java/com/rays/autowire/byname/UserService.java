package com.rays.autowire.byname;

public class UserService {

	private UserDAOInt userDao;	//object of First Interface

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void add() {
		userDao.add();
	}

}