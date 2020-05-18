package com.hutb.cfs.donor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.donor.entity.Donation;
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
	
	@Select("select * from t_cfs_donor_project where donor_id = #{donor_id} order by donate_time desc")
	public List<Donation> getDonatedProject(int donor_id);
	
	@Select("select donor_name,donate_amount,donate_time from t_cfs_donor_project where project_id = #{project_id} order by donate_time desc")
	public List<Donation> getProjectDonate(int project_id);
	
	@Select("select * from t_cfs_donor_project limit #{currentIndex},#{pageSize}")
	public List<Donation> getAllDonation(@Param("currentIndex") int currentIndex,@Param("pageSize") int pageSize);
	
	@Select("select count(1) from t_cfs_donor_user_info where username = #{username}")
	public int checkUsername(String username);
}
