package com.hutb.cfs.admin.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.admin.entity.Statistic;
import com.hutb.cfs.basedao.BaseDao;

public interface StatisticDao extends BaseDao {

	@Update("update t_cfs_statistic set foundation_count = foundation_count + 1")
	public void addFoundation_Count();
	
	@Update("update t_cfs_statistic set foundation_user_count = foundation_user_count + 1")
	public void addFoundation_User_Count();
	
	@Update("update t_cfs_statistic set project_count = project_count + 1")
	public void addProject_Count();
	
	@Update("update t_cfs_statistic set donor_count = donor_count + 1")
	public void addDonor_Count();
	
	@Update("update t_cfs_statistic set amount_count = amount_count + #{donate_amount}")
	public void addAmount_Count(int donate_amount);
	
	@Update("update t_cfs_statistic set donate_count = donate_count + 1")
	public void addDonate_Count();
	
	@Select("select * from t_cfs_statistic")
	public Statistic getStatistic();
}
