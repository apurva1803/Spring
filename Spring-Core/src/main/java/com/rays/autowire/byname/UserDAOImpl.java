package com.rays.autowire.byname;

//second interface where first interface is implemented
public class UserDAOImpl implements UserDAOInt {

	public void add() {
		System.out.println("add method...");
	}

}