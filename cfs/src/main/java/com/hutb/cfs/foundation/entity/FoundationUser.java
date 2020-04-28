package com.hutb.cfs.foundation.entity;

public class FoundationUser {
	
	private int id;
	private int foundation_id;
	private String uuid;//对应钱包
	private String username;
	private String password;
	private String tel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFoundation_id() {
		return foundation_id;
	}
	public void setFoundation_id(int foundation_id) {
		this.foundation_id = foundation_id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String role;
}
