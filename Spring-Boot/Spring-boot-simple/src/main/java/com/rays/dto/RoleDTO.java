package com.rays.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_role")
public class RoleDTO extends BaseDTO{

	@Column(name = "NAME", length = 45)
	private String name;

	@Column(name = "DESCRIPTION", length = 45)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
