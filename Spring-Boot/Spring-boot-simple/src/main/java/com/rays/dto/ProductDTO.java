package com.rays.dto;

import com.rays.common.BaseDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "st_product")
public class ProductDTO extends BaseDTO{

	@Column(name = "PRODUCT_NAME")
	private String productName;
	
	@Column(name = "PRICE")
	private Double price;
	
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	@Column(name = "CATEGORY")
	private String category;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
