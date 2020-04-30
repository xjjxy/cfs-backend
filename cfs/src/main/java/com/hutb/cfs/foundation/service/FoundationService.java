package com.hutb.cfs.foundation.service;

import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;


public interface FoundationService {

	int addFoundationUser(FoundationUser fu);
	
	FoundationUser getFoundationUser(String username,String password,String role);
	
	
	int addWalletUUID(String uuid,int id);
	
	int addFoundation(Foundation f);
	
	int addFouondationId(int foundation_id,int id);
	
	Foundation getFoundation(int id);
	
	String getUUID(int foundation_id);
}
