package com.hutb.cfs.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.hutb.cfs.admin.entity.LoginLog;
import com.hutb.cfs.basedao.BaseDao;

public interface Login_LogDao extends BaseDao {

	@Insert("insert into t_cfs_login_log (username,user_type,login_date) values(#{username},#{user_type},#{login_date})")
	public void loginLog(LoginLog log);
	
	@Select("select * from t_cfs_login_log")
	public List<LoginLog> getLoginLog();
	
}
