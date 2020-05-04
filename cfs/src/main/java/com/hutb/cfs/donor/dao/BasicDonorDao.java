package com.hutb.cfs.donor.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.donor.entity.Donor;

public interface BasicDonorDao extends BaseDao {

	/**
	 * 
	 * @param donor
	 * @return the result of addDonor
	 */
	@Insert("insert into t_cfs_donor_user_info(name,username,password,tel) values(#{name},#{username},#{password},#{tel})")
	public int addDonor(Donor donor);
	
	@Select("select * from t_cfs_donor_user_info where username = #{username} and password = #{password} and role = #{role}")
	public Donor getDonor(@Param("username")String username,@Param("password")String password,@Param("role")String role);
	
	@Update("update t_cfs_donor_user_info set uuid = #{uuid} where id = #{id}")
	public int addWalletUUID(@Param("uuid")String uuid,@Param("id")int id);
}
