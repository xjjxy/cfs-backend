package com.hutb.cfs.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.hutb.cfs.admin.entity.AuditLog;
import com.hutb.cfs.basedao.BaseDao;

public interface Audit_LogDao extends BaseDao {
	/**
	 * audit_type;
	aduit_result;
	audit_operator;
	audit_description;
	audit_time;
	 * @param log
	 */

	@Insert("insert into t_cfs_audit_log (audit_type,audit_result,audit_operator,audit_description,audit_time)"
			+ " values(#{audit_type},#{audit_result},#{audit_operator},#{audit_description},#{audit_time})")
	public int addAudit_Log(AuditLog log);
	
	@Select("select * from t_cfs_audit_log")
	public List<AuditLog> getAudti_Log();
}
