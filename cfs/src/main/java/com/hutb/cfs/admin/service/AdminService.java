package com.hutb.cfs.admin.service;

import java.util.List;

import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.Login_Log;
import com.hutb.cfs.foundation.entity.Foundation;

public interface AdminService {

	Admin getAdmin(Admin admin);
	
	List<Foundation> getNHFoundation();
	
	List<Foundation> getIsHFoundation();
	
	int handleFoundation(Foundation f);
	
	void loginLog(Login_Log log);
}
