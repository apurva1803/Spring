package com.rays.autowire.bysetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.AppConfig;

public class TestBySetter {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserServiceSetter s = context.getBean("userServiceSetter",UserServiceSetter.class);
		
		s.add();
	}
}
