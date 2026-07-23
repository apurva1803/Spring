package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;
	
	public void save(UserDTO dto) {
		
		if(dto.getId()>0) {
			dao.update(dto);
			return;
		}
		
		dao.add(dto);
	}
	
	public void delete(int id) {
		dao.delete(id);
	}
	
	public UserDTO findById(int id) {
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
