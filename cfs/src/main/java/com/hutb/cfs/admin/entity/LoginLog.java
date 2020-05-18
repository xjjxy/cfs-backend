package com.hutb.cfs.admin.entity;

public class LoginLog {

	private int id;
	private String username;
	private String user_type;
	private String login_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getLogin_date() {
		return login_date;
	}
	public void setLogin_date(String login_date) {
		this.login_date = login_date;
	}
	@Override
	public String toString() {
		return "Login_Log [id=" + id + ", username=" + username + ", user_type=" + user_type + ", login_date="
				+ login_date + "]";
	}
	
	

}
