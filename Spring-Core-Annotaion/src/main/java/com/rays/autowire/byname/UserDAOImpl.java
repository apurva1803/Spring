package com.rays.autowire.byname;

import org.springframework.stereotype.Component;

@Component("userDAOImplN")
public class UserDAOImpl implements UserDAOInt{

	@Override
	public void add() {
		
		System.out.println("add method...");
		
	}

}
