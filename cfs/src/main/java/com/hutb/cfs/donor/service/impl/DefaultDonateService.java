package com.hutb.cfs.donor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.donor.dao.DonateDao;
import com.hutb.cfs.donor.service.DonateService;
import com.hutb.cfs.foundation.entity.Project;

@Service
public class DefaultDonateService implements DonateService {

	@Autowired
	private DonateDao donateDao;
	
	@Override
	public List<Project> getAllProjectBasicInfo(long now,int currentIndex,int pageSize) {
		// TODO Auto-generated method stub
		List<Project> list = donateDao.getAllProjectBasicInfo(now,currentIndex,pageSize);
//		System.out.println("list:"+list);
		return list;
	}

	@Override
	public Project getProjectDetail(int id) {
		// TODO Auto-generated method stub
		return donateDao.getProjectDetail(id);
	}

}
