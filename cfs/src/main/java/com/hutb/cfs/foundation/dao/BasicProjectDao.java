package com.hutb.cfs.foundation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.foundation.entity.Project;

public interface BasicProjectDao extends BaseDao{

	
	@Insert("insert into t_cfs_basic_project_info (name,foundation_id,description,begin_time,end_time,img) values(#{name},#{foundation_id},#{description},#{begin_time},#{end_time},#{img})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	public int addProject(Project p);
	
	
	@Select("select * from t_cfs_basic_project_info where foundation_id = #{foundation_id}")
	public List<Project> getAllMyProject(int foundation_id);
	
	@Select("select name from t_cfs_foundation_info where id = #{foundation_id}")
	public String getFoundationName(int foundation_id);
}
