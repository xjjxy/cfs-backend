package com.hutb.cfs.foundation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hutb.cfs.foundation.dao.BasicProjectDao;
import com.hutb.cfs.foundation.entity.Project;
import com.hutb.cfs.foundation.service.BasicProjectService;


@Component
public class DefaultProjectService implements BasicProjectService {

	@Autowired
	private BasicProjectDao projectDao;
	
	
	@Override
	public int addProject(Project p) {
		// TODO Auto-generated method stub
		return projectDao.addProject(p);
	}


	@Override
	public List<Project> getAllProject(int foundation_id) {
		// TODO Auto-generated method stub
		return projectDao.getAllProject(foundation_id);
	}

}
