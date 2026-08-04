package com.rays.form;

import jakarta.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.UserDTO;

public class LoginForm extends BaseForm{

	@NotEmpty(message = "Login ID is rrequired")
	private String loginId;
	
	@NotEmpty(message = "Password is rrequired")
	private String password;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setLoginId(loginId);
		dto.setPassword(password);
		return dto;
	}
}
