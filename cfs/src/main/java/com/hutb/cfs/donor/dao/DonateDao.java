package com.hutb.cfs.donor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.donor.entity.Donation;
import com.hutb.cfs.foundation.entity.Project;

public interface DonateDao extends BaseDao {

	// " and begin_time < #{now} and end_time > #{now} limit
	// #{currentIndex},#{pageSize}"
	@Select("select id,name,foundation_name,begin_time,end_time,donate_count,comment_count,level,img from t_cfs_basic_project_info where audit_status != 0 and begin_time < #{now}"
			+ " and end_time > #{now} and name like #{project_name} order by level desc limit #{currentIndex},#{pageSize}")
	public List<Project> getAllProjectBasicInfo(@Param("now") long now, @Param("currentIndex") int currentIndex,
			@Param("pageSize") int pageSize,@Param("project_name")String project_name);

	@Select("select * from t_cfs_basic_project_info where id = #{id}")
	public Project getProjectDetail(int id);

	@Insert("insert into t_cfs_donor_project(donor_id,donor_name,foundation_id,foundation_name,project_id,project_name,donate_amount,donate_time) "
			+ "values(#{donor_id},#{donor_name},#{foundation_id},#{foundation_name},#{project_id},#{project_name},#{donate_amount},#{donate_time})")
	public int addDonation(Donation donation);
	
//	@Select("select count(project_id) from t_cfs_donor_project where project_id = #{project_id}")
	@Update("update t_cfs_basic_project_info set donate_count = donate_count+1 where id = #{project_id}")
	public int updateDonateCount(int project_id);
}
