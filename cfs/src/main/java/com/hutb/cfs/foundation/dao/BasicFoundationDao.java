package com.hutb.cfs.foundation.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;

public interface BasicFoundationDao extends BaseDao {

	@Insert("insert into t_cfs_foundation_user_info(username,password,tel) values(#{username},#{password},#{tel})")
	int addFoundationUser(FoundationUser fu);
	
	@Select("select * from t_cfs_foundation_user_info where username = #{username} and password = #{password}")
	FoundationUser getFoundationUser(@Param("username")String username,@Param("password")String password);
	
	
	@Update("update t_cfs_foundation_user_info set uuid = #{uuid} where id = #{id}")
	int addWalletUUID(@Param("uuid")String uuid,@Param("id")int id);
	
	@Insert("insert into t_cfs_foundation_info (name,license,level,modify_date,certification,audit_status) values(#{name},#{license},#{level},#{modify_date},#{certification},#{audit_status})")
	int addFoundation(Foundation f);
	
}
