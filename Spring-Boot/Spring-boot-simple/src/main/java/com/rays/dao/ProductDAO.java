package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rays.dto.ProductDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class ProductDAO {

	@PersistenceContext
	EntityManager entityManager;
	
	public long add(ProductDTO dto) {
		
		entityManager.persist(dto);
		return dto.getId();
	}
	
	public void update(ProductDTO dto) {
		
		entityManager.merge(dto);	// merge method to insert or update
	}
	
	public void delete(long id) {
		ProductDTO dto = findByPk(id);
		
		entityManager.remove(dto);	// remove method to delete
	}
	
	public ProductDTO findByPk(long id) {
		
		ProductDTO dto = entityManager.find(ProductDTO.class, id);	// find method to find by id
		
		return dto;
	}
	
	public List<ProductDTO> search(ProductDTO dto, int pageNo, int pageSize){
		
		// to create query
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		// to create search query of given .class
		// select * from RoleDTO where 1 = 1;
		CriteriaQuery<ProductDTO> cq = builder.createQuery(ProductDTO.class);

		// to get attribute of given .class
		Root<ProductDTO> root = cq.from(ProductDTO.class);
		
		// create Object of predicate to hold search filters
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {
			if (dto.getId() != null && dto.getId() > 0) {
				predicateList.add(builder.equal(root.get("id"), dto.getId()));
			}
			if (dto.getProductName() != null && dto.getProductName().length() > 0) {
				predicateList.add(builder.like(root.get("productName"), dto.getProductName() + "%"));
			}
			if (dto.getPrice() != null && dto.getPrice() > 0) {
				predicateList.add(builder.equal(root.get("price"), dto.getPrice()));
			}
			if (dto.getQuantity() != null && dto.getQuantity() > 0) {
				predicateList.add(builder.equal(root.get("quantity"), dto.getQuantity()));
			}
			if (dto.getCategory() != null && dto.getCategory().length() > 0) {
				predicateList.add(builder.equal(root.get("category"), dto.getCategory()));
			}
			
		}		

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));
		
		TypedQuery<ProductDTO> query = entityManager.createQuery(cq);
		
		if(pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
			
		}
		
		List<ProductDTO> list = query.getResultList();
		
		return list;

	}
	
	public ProductDTO findByUniqueColumn(String attribute, String value) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<ProductDTO> cq = builder.createQuery(ProductDTO.class);
		
		Root<ProductDTO> root = cq.from(ProductDTO.class);
		
		Predicate condition = builder.equal(root.get(attribute), value);
		
		cq.where(condition);
		
		TypedQuery<ProductDTO> tq = entityManager.createQuery(cq);
		
		List<ProductDTO> list = tq.getResultList();
		
		ProductDTO dto = null;
		
		if(list.size() == 1) {
			dto = list.get(0);
		}
		
		return dto;
		
	}
}
