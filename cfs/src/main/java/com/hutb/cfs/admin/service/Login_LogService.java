package com.hutb.cfs.admin.service;

import java.util.List;

import com.hutb.cfs.admin.entity.LoginLog;

public interface Login_LogService {

	public void loginLog(LoginLog log);
	
	public List<LoginLog> getLoginLog();
}
