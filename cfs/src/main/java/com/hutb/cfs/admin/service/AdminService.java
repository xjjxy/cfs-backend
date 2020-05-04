package com.hutb.cfs.admin.service;

import java.util.List;

import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.Login_Log;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.Project;

public interface AdminService {

	public Admin getAdmin(Admin admin);
	
	public List<Foundation> getNHFoundation();
	
	public List<Foundation> getIsHFoundation();
	
	public int handleFoundation(Foundation f);
	
	public void loginLog(Login_Log log);
	
	public List<Project> geNHProject();
	
	public int handleProject(Project p);
	
	public List<Project> getIsHProject();
}
