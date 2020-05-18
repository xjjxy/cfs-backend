package com.hutb.cfs.foundation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.StatisticDao;
import com.hutb.cfs.foundation.dao.BasicFoundationDao;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;
import com.hutb.cfs.foundation.service.FoundationService;

@Service
public class DefaultFoundationService implements FoundationService {

	@Autowired
	private BasicFoundationDao basicFoundationDao;
	
	@Autowired
	private StatisticDao statisticDao;
	
	
	
	@Override
	public String getUUID(int foundation_id) {
		// TODO Auto-generated method stub
		return basicFoundationDao.getUUID(foundation_id);
	}
	@Override
	public int addFoundationUser(FoundationUser fu) {
		// TODO Auto-generated method stub
		statisticDao.addFoundation_User_Count();
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
		statisticDao.addFoundation_Count();
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
