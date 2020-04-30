package com.hutb.cfs.foundation.service;

import java.util.List;

import com.hutb.cfs.foundation.entity.Project;

public interface BasicProjectService {

	
	
	int addProject(Project p);
	
	List<Project> getAllProject(int foundation_id);
}
