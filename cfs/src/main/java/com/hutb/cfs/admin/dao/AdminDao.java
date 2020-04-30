package com.hutb.cfs.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.admin.entity.Login_Log;
import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.foundation.entity.Foundation;

public interface AdminDao extends BaseDao {

	
	@Select("select * from t_cfs_admin_info where username = #{username} and password = #{password}")
	Admin getAdmin(Admin admin);
	
	@Select("select * from t_cfs_foundation_info where audit_status = 0")
	List<Foundation> getNHFoundation();
	
	@Select("select * from t_cfs_foundation_info where audit_status != 0")
	List<Foundation> getIsHFoundation();
	
	@Update("update t_cfs_foundation_info set level = #{level},modify_date = #{modify_date},audit_status = #{audit_status} where id = #{id}")
	int handleFoundation(Foundation f);
	
	@Insert("insert into t_cfs_login_log (username,user_type,login_date) values(#{username},#{user_type},#{login_date})")
	void loginLog(Login_Log log);
}
