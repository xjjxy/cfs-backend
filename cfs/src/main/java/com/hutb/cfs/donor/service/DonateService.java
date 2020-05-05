package com.hutb.cfs.donor.service;

import java.util.List;

import com.hutb.cfs.foundation.entity.Project;

public interface DonateService {

	
	public List<Project> getAllProjectBasicInfo(long now,int currentIndex,int pageSize);
	
	
	public Project getProjectDetail(int id);
}
