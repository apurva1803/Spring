package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.BookDAO;
import com.rays.dto.BookDTO;

@Service
@Transactional
public class BookService {

	@Autowired
	BookDAO dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void save(BookDTO dto) {
		
		if(dto.getId() != null && dto.getId() > 0) {
			dao.update(dto);
		}else {
			dao.add(dto);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		
		dao.delete(id);
	}
	
	@Transactional(readOnly = true)
	public BookDTO findById(long id) {
		
		return dao.findByPk(id);
	}
	
	@Transactional(readOnly = true)
	public List<BookDTO> search(BookDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
	
}
