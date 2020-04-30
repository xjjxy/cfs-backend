package com.hutb.cfs.admin.dao;

import com.hutb.cfs.foundation.entity.Project;

public interface DetailDao {
	
	void createDetail(String wallet_address,long target_amount,int project_id);
	
	
	Project getDetail(int project_id);

}
