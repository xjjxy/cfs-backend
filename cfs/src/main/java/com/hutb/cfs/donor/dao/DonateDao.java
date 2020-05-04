package com.hutb.cfs.donor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.foundation.entity.Project;

public interface DonateDao extends BaseDao {

	@Select("select * from t_cfs_basic_project_info where audit_status != 0 and begin_time < #{now}")
	public List<Project> getAllProject(long now);
}
