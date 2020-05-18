package com.hutb.cfs.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.Login_LogDao;
import com.hutb.cfs.admin.entity.LoginLog;
import com.hutb.cfs.admin.service.Login_LogService;


@Service
public class DefaultLoginLogService implements Login_LogService {

	
	@Autowired
	private Login_LogDao loginLogDao;
	
	@Override
	public void loginLog(LoginLog log) {
		// TODO Auto-generated method stub
		loginLogDao.loginLog(log);
	}

	@Override
	public List<LoginLog> getLoginLog() {
		// TODO Auto-generated method stub
		return loginLogDao.getLoginLog();
	}

}
