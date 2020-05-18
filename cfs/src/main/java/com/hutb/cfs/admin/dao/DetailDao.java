package com.hutb.cfs.admin.dao;

import com.hutb.cfs.admin.entity.Wallet;
import com.hutb.cfs.foundation.entity.Phase;
import com.hutb.cfs.foundation.entity.Project;

public interface DetailDao {
	
	public void createDetail(String wallet_address,long target_amount,int project_id);
	
	
	public Project getDetail(int project_id);
	
	public int donate(int project_id,int donate_amount,Wallet wallet);
	
	public void addPhase(int project_id,Phase phase);

	public int getPhaseSize(int project_id);
	
	public Phase getPhase(int index,int project_id);
}
