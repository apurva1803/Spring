package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("testUser")
public class TestUser {
	
	@Autowired
	public UserService service = null;
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		TestUser test = (TestUser) context.getBean("userTest");
		
		test.testAdd();
	}

	private void testAdd() {
		
		UserDTO dto = new UserDTO();
		dto.setFirstName("Shyam");
		dto.setLastName("Yadav");
		dto.setLogin("shyam@gmail.com");
		dto.setPassword("shyam123");
		service.save(dto);
		
	}

}
