package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rays.dto.BookDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class BookDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public long add(BookDTO dto) {
		
		entityManager.persist(dto);
		return dto.getId();
	}
	
	public void update(BookDTO dto) {
		
		entityManager.merge(dto);	// merge method to insert or update
	}
	
	public void delete(long id) {
		BookDTO dto = findByPk(id);
		
		entityManager.remove(dto);	// remove method to delete
	}
	
	public BookDTO findByPk(long id) {
		
		BookDTO dto = entityManager.find(BookDTO.class, id);	// find method to find by id
		
		return dto;
	}
	
	public List<BookDTO> search(BookDTO dto, int pageNo, int pageSize){
		
		// to create query
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		// to create search query of given .class
		// select * from RoleDTO where 1 = 1;
		CriteriaQuery<BookDTO> cq = builder.createQuery(BookDTO.class);

		// to get attribute of given .class
		Root<BookDTO> root = cq.from(BookDTO.class);
		
		// create Object of predicate to hold search filters
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}
			if (dto.getTitle() != null && dto.getTitle().length() > 0) {
				predicateList.add(builder.like(root.get("title"), dto.getTitle() + "%"));
			}
			if (dto.getPrice() != null && dto.getPrice() > 0) {
				predicateList.add(builder.equal(root.get("price"), dto.getPrice()));
			}
			if (dto.getPublicationYear() != null && dto.getPublicationYear() > 0) {
				predicateList.add(builder.equal(root.get("publicationYear"), dto.getPublicationYear()));
			}
			
			
		}		

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		
		TypedQuery<BookDTO> query = entityManager.createQuery(cq);
		
		if(pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
			
		}
		
		List<BookDTO> list = query.getResultList();
		
		return list;

	}
	
	public BookDTO findByUniqueColumn(String attribute, String value) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<BookDTO> cq = builder.createQuery(BookDTO.class);
		
		Root<BookDTO> root = cq.from(BookDTO.class);
		
		Predicate condition = builder.equal(root.get(attribute), value);
		
		cq.where(condition);
		
		TypedQuery<BookDTO> tq = entityManager.createQuery(cq);
		
		List<BookDTO> list = tq.getResultList();
		
		BookDTO dto = null;
		
		if(list.size() == 1) {
			dto = list.get(0);
		}
		
		return dto;
		
	}
}
