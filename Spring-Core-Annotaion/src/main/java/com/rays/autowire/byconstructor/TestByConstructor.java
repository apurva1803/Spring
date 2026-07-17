package com.rays.autowire.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.AppConfig;

public class TestByConstructor {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserServiceConstructor s = context.getBean("userServiceConstructor",UserServiceConstructor.class);
		
		s.add();
	}
}
