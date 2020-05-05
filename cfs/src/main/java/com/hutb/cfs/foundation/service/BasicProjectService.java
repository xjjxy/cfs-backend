package com.hutb.cfs.foundation.service;

import java.util.List;

import com.hutb.cfs.foundation.entity.Project;

public interface BasicProjectService {

	
	
	public int addProject(Project p);
	
	public List<Project> getAllMyProject(int foundation_id);
	
	public String getFoundationName(int foundation_id);
}
