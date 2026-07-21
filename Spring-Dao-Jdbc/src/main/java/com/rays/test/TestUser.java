package com.rays.test;

import java.util.Iterator;
import java.util.List;

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
		//test.testDelete();
		//test.testFindByPk();
		//test.testSearch();
		//test.testFindByLogin();
		test.testAuthencticate();
	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(3);
		dto.setFirstName("Shyam");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");

		long id = service.add(dto);

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

	public void testFindByPk() {

		UserDTO dto = new UserDTO();

		dto = service.findByPk(2);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());

	}
	
	public void testSearch() {

		UserDTO dto = new UserDTO();
		int pageNo = 1;
		int pageSize = 5;

		dto.setFirstName("a");
		List<UserDTO> list = service.search(dto, pageNo, pageSize);

		Iterator<UserDTO> it = list.iterator();

		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		}

	}
	
	private void testAuthencticate() {

		UserDTO dto = new UserDTO();

		dto = service.authenticate("apurva@gmail.com", "pass123");

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("invalid login or password");
		}

	}

	private void testFindByLogin() {
		UserDTO dto = new UserDTO();

		dto = service.findByLogin("apurva@gmail.com");

		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("user not found");
		}

	}

}