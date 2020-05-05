package com.hutb.cfs.donor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.foundation.entity.Project;

public interface DonateDao extends BaseDao {

	//" and begin_time < #{now} and end_time > #{now} limit #{currentIndex},#{pageSize}"
	@Select("select id,name,foundation_name,begin_time,end_time,donate_count,comment_count,level,img from t_cfs_basic_project_info where audit_status != 0 and begin_time < #{now}"
			+ " and end_time > #{now} order by level desc limit #{currentIndex},#{pageSize}")
	public List<Project> getAllProjectBasicInfo(@Param("now")long now,@Param("currentIndex")int currentIndex,@Param("pageSize")int pageSize);
	
	@Select("select * from t_cfs_basic_project_info where id = #{id}")
	public Project getProjectDetail(int id);
}
