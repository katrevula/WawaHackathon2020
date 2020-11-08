package com.emobileconnect.emobileconnect.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class RequestDTO {
	
	private MultipartFile file;
	
	private String name;
	
	@Email
	private String email;
	
	@NotBlank
	private String mobile;
	
	
	private Integer planId;
	
	
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Integer getPlanId() {
		return planId;
	}


	public void setPlanId(Integer planId) {
		this.planId = planId;
	}


	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
