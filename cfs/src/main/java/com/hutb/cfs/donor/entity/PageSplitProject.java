package com.hutb.cfs.donor.entity;

import java.util.List;

import com.hutb.cfs.foundation.entity.Project;

public class PageSplitProject {

	private int pageSize = 5;//页面大小
	private int currentPage = 1;//当前页
	private int totalCount = 0;//总数据量
	List<Project> list;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<Project> getList() {
		return list;
	}
	public void setList(List<Project> list) {
		this.list = list;
	}
	
	
}
