package com.hutb.cfs.donor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.StatisticDao;
import com.hutb.cfs.donor.dao.DonateDao;
import com.hutb.cfs.donor.entity.Donation;
import com.hutb.cfs.donor.service.DonateService;
import com.hutb.cfs.foundation.entity.Project;

@Service
public class DefaultDonateService implements DonateService {

	@Autowired
	private DonateDao donateDao;
	
	@Autowired
	private StatisticDao statisticDao;
	
	@Override
	public List<Project> getAllProjectBasicInfo(long now,int currentIndex,int pageSize,String project_name) {
		// TODO Auto-generated method stub
		List<Project> list = donateDao.getAllProjectBasicInfo(now,currentIndex,pageSize,project_name);
//		System.out.println("list:"+list);
		return list;
	}

	@Override
	public Project getProjectDetail(int id) {
		// TODO Auto-generated method stub
		return donateDao.getProjectDetail(id);
	}

	@Override
	public int addDonation(Donation donation) {
		// TODO Auto-generated method stub
		statisticDao.addDonate_Count();
		statisticDao.addAmount_Count(donation.getDonate_amount());
		return donateDao.addDonation(donation);
	}
	
	@Override
	public int updateDonateCount(int project_id) {
		// TODO Auto-generated method stub
		return donateDao.updateDonateCount(project_id);
	}

}
