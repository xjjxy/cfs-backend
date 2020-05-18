package com.hutb.cfs.admin.service;

import java.util.List;

import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.LoginLog;
import com.hutb.cfs.admin.entity.Statistic;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.Project;

public interface AdminService {

	public Admin getAdmin(Admin admin);
	
	public List<Foundation> getNHFoundation();
	
	public List<Foundation> getIsHFoundation();
	
	public int handleFoundation(Foundation f);
	
	public void loginLog(LoginLog log);
	
	public List<Project> geNHProject();
	
	public int handleProject(Project p);
	
	public List<Project> getIsHProject();
	
	public Statistic getStatistic();
}
