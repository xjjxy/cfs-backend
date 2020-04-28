package com.hutb.cfs.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.AdminDao;
import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.service.AdminService;

@Service
public class DefaultAdminService implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Override
	public Admin getAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.getAdmin(admin);
	}
}
