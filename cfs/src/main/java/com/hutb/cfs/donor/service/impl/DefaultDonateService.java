package com.hutb.cfs.donor.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hutb.cfs.donor.dao.DonateDao;
import com.hutb.cfs.donor.service.DonateService;
import com.hutb.cfs.foundation.entity.Project;

@Service
public class DefaultDonateService implements DonateService {

	private DonateDao donateDao;
	
	@Override
	public List<Project> getAllProject(long now) {
		// TODO Auto-generated method stub
		
		return donateDao.getAllProject(now);
	}

}
