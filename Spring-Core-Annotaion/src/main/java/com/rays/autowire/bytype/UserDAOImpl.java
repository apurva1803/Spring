package com.rays.autowire.bytype;

import org.springframework.stereotype.Component;

@Component("userDAOImplT")
public class UserDAOImpl implements UserDAOInt{

	@Override
	public void add() {
		
		System.out.println("add method...");
		
	}

}
