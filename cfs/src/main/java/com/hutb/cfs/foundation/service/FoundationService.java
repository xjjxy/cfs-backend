package com.hutb.cfs.foundation.service;

import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;


public interface FoundationService {

	public int addFoundationUser(FoundationUser fu);
	
	public FoundationUser getFoundationUser(String username,String password,String role);
	
	
	public int addWalletUUID(String uuid,int id);
	
	public int addFoundation(Foundation f);
	
	public int addFouondationId(int foundation_id,int id);
	
	public Foundation getFoundation(int id);
	
	public String getUUID(int foundation_id);
}
