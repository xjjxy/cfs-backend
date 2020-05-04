package com.hutb.cfs.admin.dao;

import com.hutb.cfs.foundation.entity.Project;

public interface DetailDao {
	
	public void createDetail(String wallet_address,long target_amount,int project_id);
	
	
	public Project getDetail(int project_id);

}
