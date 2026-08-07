package com.rays.form;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ProductDTO;
import com.rays.dto.UserDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductForm extends BaseForm{

	@NotEmpty(message = "productName is required")
	private String productName;
	
	@NotNull(message = "price is required")
	private Double price;
	
	@NotNull(message = "quantity is required")
	private Integer quantity;
	
	@NotEmpty(message = "category is required")
	private String category;
	
	public ProductForm() {
		
	}

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
	
	@Override
	public BaseDTO getDto() {
		ProductDTO dto = (ProductDTO) initDTO(new ProductDTO());
		dto.setProductName(productName);
		dto.setPrice(price);
		dto.setQuantity(quantity);
		dto.setCategory(category);
		return dto;
	}
}
