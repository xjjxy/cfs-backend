package com.hutb.cfs.admin.service;

import java.util.List;

import com.hutb.cfs.admin.entity.AuditLog;


public interface Audit_LogService {

	
	public int addAudit_Log(AuditLog log);
	
	public List<AuditLog> getAudti_Log();
}
