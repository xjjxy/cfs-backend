package com.hutb.cfs.foundation.service;

import org.apache.ibatis.annotations.Param;

import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;


public interface FoundationUserService {

	int addFoundationUser(FoundationUser fu);
	
	FoundationUser getFoundationUser(@Param("username")String username,@Param("password")String password);
	
	
	int addWalletUUID(String uuid,int id);
	
	int addFoundation(Foundation f);
}
