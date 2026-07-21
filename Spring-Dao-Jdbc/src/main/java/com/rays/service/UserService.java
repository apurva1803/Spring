package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;

	public long add(UserDTO dto) {
		UserDTO existDto = findByLogin(dto.getLogin());

		if (existDto != null) {
			throw new RuntimeException("login already exist");
		}

		long i = dao.add(dto);
		
		return i;
	}
	
	public void update(UserDTO dto) {
		dao.update(dto);

	}

	public void delete(int id) {
		dao.delete(id);
	}


	public UserDTO findByPk(long id) {
		return dao.findByPk(id);
	}

	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public UserDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
}