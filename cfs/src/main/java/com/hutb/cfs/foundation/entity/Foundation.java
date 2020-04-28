package com.hutb.cfs.foundation.entity;

public class Foundation {

	private int id;
	private String name;
	private String license;
	private int level;
	private int modify_date;
	private String certification;
	private String audit_status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getModify_date() {
		return modify_date;
	}
	public void setModify_date(int modify_date) {
		this.modify_date = modify_date;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}
	@Override
	public String toString() {
		return "Foundation [id=" + id + ", name=" + name + ", license=" + license + ", level=" + level
				+ ", modify_date=" + modify_date + ", certification=" + certification + ", audit_status=" + audit_status
				+ "]";
	}
	
	
}
