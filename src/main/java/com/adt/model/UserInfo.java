package com.adt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_INFO")
public class UserInfo {
	@Id
	private Integer userId;
	private String name;
	private String address;
	private String email;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}
	public UserInfo(Integer userId, String name, String address, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.address = address;
		this.email = email;
	}
	public UserInfo() {
		super();
		
	}
	
	
	
}
