package com.hutb.cfs.donor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.StatisticDao;
import com.hutb.cfs.donor.dao.BasicDonorDao;
import com.hutb.cfs.donor.entity.Donation;
import com.hutb.cfs.donor.entity.Donor;
import com.hutb.cfs.donor.service.BasicDonorService;

@Service
public class DefaultBasicDonorService implements BasicDonorService {
	
	@Autowired
	private BasicDonorDao basicDonorDao;
	
	
	@Autowired
	private StatisticDao statisticDao;

	@Override
	public int addDonor(Donor donor) {
		statisticDao.addDonor_Count();
		return basicDonorDao.addDonor(donor);
	}

	@Override
	public Donor getDonor(String username, String password,String role) {
		return basicDonorDao.getDonor(username, password,role);
	}

	@Override
	public int addWalletUUID(String uuid, int id) {
		return basicDonorDao.addWalletUUID(uuid, id);
	}

	@Override
	public List<Donation> getDonatedProject(int donor_id) {
		return basicDonorDao.getDonatedProject(donor_id);
	}

	@Override
	public List<Donation> getProjectDonate(int project_id) {
		// TODO Auto-generated method stub
		return basicDonorDao.getProjectDonate(project_id);
	}

	@Override
	public List<Donation> getAllDonation(int currentIndex,int pageSize) {
		// TODO Auto-generated method stub
		return basicDonorDao.getAllDonation(currentIndex,pageSize);
	}

	@Override
	public int checkUsername(String username) {
		// TODO Auto-generated method stub
		return basicDonorDao.checkUsername(username);
	}
	
	

}
