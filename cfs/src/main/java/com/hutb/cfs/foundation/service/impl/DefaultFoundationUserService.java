package com.hutb.cfs.foundation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.foundation.dao.BasicFoundationDao;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;
import com.hutb.cfs.foundation.service.FoundationUserService;

@Service
public class DefaultFoundationUserService implements FoundationUserService {

	@Autowired
	BasicFoundationDao basicFoundationDao;
	
	@Override
	public int addFoundationUser(FoundationUser fu) {
		// TODO Auto-generated method stub
		return basicFoundationDao.addFoundationUser(fu);
	}
	
	@Override
	public FoundationUser getFoundationUser(String username, String password,String role) {
		// TODO Auto-generated method stub
		return basicFoundationDao.getFoundationUser(username, password,role);
	}

	@Override
	public int addWalletUUID(String uuid, int id) {
		// TODO Auto-generated method stub
		return basicFoundationDao.addWalletUUID(uuid, id);
	}

	@Override
	public int addFoundation(Foundation f) {
		// TODO Auto-generated method stub
		return basicFoundationDao.addFoundation(f);
	}

	@Override
	public int addFouondationId(int foundation_id, int id) {
		// TODO Auto-generated method stub
		return basicFoundationDao.addFouondationId(foundation_id, id);
	}

	@Override
	public Foundation getFoundation(int id) {
		// TODO Auto-generated method stub
		return basicFoundationDao.getFoundation(id);
	}
}
