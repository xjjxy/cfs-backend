package com.hutb.cfs.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.AdminDao;
import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.Login_Log;
import com.hutb.cfs.admin.service.AdminService;
import com.hutb.cfs.foundation.entity.Foundation;

@Service
public class DefaultAdminService implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Override
	public Admin getAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.getAdmin(admin);
	}

	@Override
	public List<Foundation> getNHFoundation() {
		// TODO Auto-generated method stub
		return adminDao.getNHFoundation();
	}

	@Override
	public int handleFoundation(Foundation f) {
		// TODO Auto-generated method stub
		return adminDao.handleFoundation(f);
	}

	@Override
	public List<Foundation> getIsHFoundation() {
		// TODO Auto-generated method stub
		return adminDao.getIsHFoundation();
	}

	@Override
	public void loginLog(Login_Log log) {
		// TODO Auto-generated method stub
		adminDao.loginLog(log);
	}
}
