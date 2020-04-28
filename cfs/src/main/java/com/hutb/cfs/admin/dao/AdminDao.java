package com.hutb.cfs.admin.dao;

import org.apache.ibatis.annotations.Select;

import com.hutb.cfs.admin.entity.Admin;
import com.hutb.cfs.basedao.BaseDao;

public interface AdminDao extends BaseDao {

	
	@Select("select * from t_cfs_admin_info where username = #{username} and password = #{password}")
	Admin getAdmin(Admin admin);
	
}
