package com.hutb.cfs.admin.entity;

public class AuditLog {

	private int id;
	private String audit_type;
	private String audit_operator;
	private String audit_result;
	private String audit_description;
	private long audit_time;
	
	
	public String getAudit_result() {
		return audit_result;
	}
	public void setAudit_result(String audit_result) {
		this.audit_result = audit_result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAudit_type() {
		return audit_type;
	}
	public void setAudit_type(String audit_type) {
		this.audit_type = audit_type;
	}
	public String getAudit_operator() {
		return audit_operator;
	}
	public void setAudit_operator(String audit_operator) {
		this.audit_operator = audit_operator;
	}
	public String getAudit_description() {
		return audit_description;
	}
	public void setAudit_description(String audit_description) {
		this.audit_description = audit_description;
	}
	public long getAudit_time() {
		return audit_time;
	}
	public void setAudit_time(long audit_time) {
		this.audit_time = audit_time;
	}
	@Override
	public String toString() {
		return "Audit_log [id=" + id + ", audit_type=" + audit_type + ", adudit_result=" + audit_result
				+ ", audit_operator=" + audit_operator + ", audit_description=" + audit_description + ", audit_time="
				+ audit_time + "]";
	}
	
	
}
