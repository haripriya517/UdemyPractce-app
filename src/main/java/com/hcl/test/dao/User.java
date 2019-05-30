package com.hcl.test.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All detail about the user")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 2,message = "Name should have atleast 2 characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Birth date should be in the past")
	private Date dateOfbirth;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String name, Date dateOfbirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfbirth = dateOfbirth;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	 
	

}
