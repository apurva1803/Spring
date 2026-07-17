package com.rays.autowire.byconstructor;

import org.springframework.stereotype.Component;

@Component("userDAOImplC")
public class UserDAOImpl implements UserDAOInt{

	@Override
	public void add() {
		
		System.out.println("add method...");
		
	}

}
