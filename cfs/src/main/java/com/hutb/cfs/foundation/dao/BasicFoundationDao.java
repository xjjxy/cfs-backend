package com.hutb.cfs.foundation.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.foundation.entity.Foundation;
import com.hutb.cfs.foundation.entity.FoundationUser;

public interface BasicFoundationDao extends BaseDao {

	@Insert("insert into t_cfs_foundation_user_info(username,password,tel) values(#{username},#{password},#{tel})")
	public int addFoundationUser(FoundationUser fu);
	
	@Select("select * from t_cfs_foundation_user_info where username = #{username} and password = #{password} and role = #{role}")
	public FoundationUser getFoundationUser(@Param("username")String username,@Param("password")String password,@Param("role")String role);
	
	
	@Update("update t_cfs_foundation_user_info set uuid = #{uuid} where id = #{id}")
	public int addWalletUUID(@Param("uuid")String uuid,@Param("id")int id);
	
	@Insert("insert into t_cfs_foundation_info (name,license,modify_date,certification,audit_status) values(#{name},#{license},#{modify_date},#{certification},#{audit_status})")
	@Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	public int addFoundation(Foundation f);
	
	@Select("select uuid from t_cfs_foundation_user_info where foundation_id = #{foundation_id}")
	public String getUUID(int foundation_id);
	
	@Update("update t_cfs_foundation_user_info set foundation_id = #{foundation_id} where id = #{id}")
	public int addFouondationId(@Param("foundation_id")int foundation_id,@Param("id")int id);
	
	@Select("select * from t_cfs_foundation_info where id = #{id}")
	public Foundation getFoundation(int id);
	
	
}
