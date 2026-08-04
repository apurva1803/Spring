package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.RoleDTO;

@Repository
public class RoleDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public long add(RoleDTO dto) {

		entityManager.persist(dto); // persist method to insert

		return dto.getId();

	}
	
	public void update(RoleDTO dto) {
		
		entityManager.merge(dto);	// merge method to insert or update
	}
	
	public void delete(long id) {
		
		RoleDTO dto = findByPk(id);
		
		entityManager.remove(dto);	// remove method to delete
	}
	
	public RoleDTO findByPk(long id) {
		
		RoleDTO dto = entityManager.find(RoleDTO.class, id);	// find method to find by id
		
		return dto;
	}
	
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize){
		
		// to create query
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		// to create search query of given .class
		// select * from RoleDTO where 1 = 1;
		CriteriaQuery<RoleDTO> cq = builder.createQuery(RoleDTO.class);

		// to get attribute of given .class
		Root<RoleDTO> root = cq.from(RoleDTO.class);
		
		// create Object of predicate to hold search filters
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				predicateList.add(builder.like(root.get("name"), dto.getName() + "%"));
			}
			if (dto.getDescription() != null && dto.getDescription().length() > 0) {
				predicateList.add(builder.like(root.get("description"), dto.getDescription() + "%"));
			}
		}		

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		
		TypedQuery<RoleDTO> query = entityManager.createQuery(cq);
		
		if(pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
			
		}
		
		List<RoleDTO> list = query.getResultList();
		
		return list;

	}
}
