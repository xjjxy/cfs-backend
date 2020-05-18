package com.hutb.cfs.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.LoginLog;
import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.Project;

public interface AdminDao extends BaseDao {

	
	@Select("select * from t_cfs_admin_info where username = #{username} and password = #{password}")
	public Admin getAdmin(Admin admin);
	
	@Select("select * from t_cfs_foundation_info where audit_status = 0")
	public List<Foundation> getNHFoundation();
	
	@Select("select * from t_cfs_foundation_info where audit_status != 0")
	public List<Foundation> getIsHFoundation();
	
	@Update("update t_cfs_foundation_info set level = #{level},modify_date = #{modify_date},audit_status = #{audit_status} where id = #{id}")
	public int handleFoundation(Foundation f);
	
	@Insert("insert into t_cfs_login_log (username,user_type,login_date) values(#{username},#{user_type},#{login_date})")
	public void loginLog(LoginLog log);
	
	@Select("select * from t_cfs_basic_project_info  where audit_status = 0")
	public List<Project> geNHProject();
	
	@Update("update t_cfs_basic_project_info set level = #{level},audit_status = #{audit_status} where id = #{id}")
	public int handleProject(Project p);
	
	@Select("select * from t_cfs_basic_project_info where audit_status != 0")
	public List<Project> getIsHProject();
}
