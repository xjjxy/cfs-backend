package com.hutb.cfs.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.admin.dao.Audit_LogDao;
import com.hutb.cfs.admin.entity.AuditLog;
import com.hutb.cfs.admin.service.Audit_LogService;

@Service
public class DefaultAuditLogService implements Audit_LogService {

	@Autowired
	private Audit_LogDao auditLogDao;
	
	@Override
	public int addAudit_Log(AuditLog log) {
		// TODO Auto-generated method stub
		return auditLogDao.addAudit_Log(log);
	}

	@Override
	public List<AuditLog> getAudti_Log() {
		// TODO Auto-generated method stub
		return auditLogDao.getAudti_Log();
	}

}
