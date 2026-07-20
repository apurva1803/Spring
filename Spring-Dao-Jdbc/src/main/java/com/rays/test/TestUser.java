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
	UserService service;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUser test = context.getBean("testUser", TestUser.class);

		//test.testAdd();
		//test.testUpdate();
		test.testDelete();
		
	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(3);
		dto.setFirstName("Shyam");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");

		int id = service.add(dto);

		System.out.println("data inserted successfully at id: " + id);

	}
	
	private void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(2);
		dto.setFirstName("Ram");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");

		service.update(dto);

	}
	
	private void testDelete() {
		service.delete(3);
	}


}