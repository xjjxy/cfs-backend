package com.hutb.cfs.donor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.donor.dao.BasicDonorDao;
import com.hutb.cfs.donor.entity.Donor;
import com.hutb.cfs.donor.entity.PageSplitProject;
import com.hutb.cfs.donor.service.BasicDonorService;

@Service
public class DefaultBasicDonorService implements BasicDonorService {
	
	@Autowired
	private BasicDonorDao basicDonorDao;

	@Override
	public int addDonor(Donor donor) {
		// TODO Auto-generated method stub
		return basicDonorDao.addDonor(donor);
	}

	@Override
	public Donor getDonor(String username, String password,String role) {
		// TODO Auto-generated method stub
		
		
		return basicDonorDao.getDonor(username, password,role);
	}

	@Override
	public int addWalletUUID(String uuid, int id) {
		// TODO Auto-generated method stub
		return basicDonorDao.addWalletUUID(uuid, id);
	}

}
