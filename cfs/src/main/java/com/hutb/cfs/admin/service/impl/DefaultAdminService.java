package com.hutb.cfs.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.AdminDao;
import com.hutb.cfs.admin.dao.StatisticDao;
import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.LoginLog;
import com.hutb.cfs.admin.entity.Statistic;
import com.hutb.cfs.admin.service.AdminService;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.Project;

@Service
public class DefaultAdminService implements AdminService {

	@Autowired
	private StatisticDao statisticDao;
	
	@Autowired
	private AdminDao adminDao;
	
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
	public void loginLog(LoginLog log) {
		// TODO Auto-generated method stub
		adminDao.loginLog(log);
	}

	@Override
	public List<Project> geNHProject() {
		// TODO Auto-generated method stub
		return adminDao.geNHProject();
	}

	@Override
	public int handleProject(Project p) {
		// TODO Auto-generated method stub
		return adminDao.handleProject(p);
	}

	@Override
	public List<Project> getIsHProject() {
		// TODO Auto-generated method stub
		return adminDao.getIsHProject();
	}

	@Override
	public Statistic getStatistic() {
		// TODO Auto-generated method stub
		return statisticDao.getStatistic();
	}
}
