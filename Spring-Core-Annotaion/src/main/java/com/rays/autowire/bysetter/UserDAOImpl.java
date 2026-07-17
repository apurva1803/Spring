package com.rays.autowire.bysetter;

import org.springframework.stereotype.Component;

@Component("userDAOImplS")
public class UserDAOImpl implements UserDAOInt{

	@Override
	public void add() {
		
		System.out.println("add method...");
		
	}

}
