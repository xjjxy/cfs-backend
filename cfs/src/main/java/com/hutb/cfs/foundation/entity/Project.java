package com.hutb.cfs.foundation.entity;

public class Project {
	
	private int id;
	private String name;
	private int foundation_id;
	private String foundation_name;
	private int level;
	private long begin_time;
	private long end_time;
	private String audit_status;
	private String description;
	private long target_amount;
	private long now_amount;
	private long last_amount;
	private String wallet_address;
	private int comment_count;
	private int donate_count;
	private String img;
	
	
	
	
	public String getFoundation_name() {
		return foundation_name;
	}
	public void setFoundation_name(String foundation_name) {
		this.foundation_name = foundation_name;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getDonate_count() {
		return donate_count;
	}
	public void setDonate_count(int donate_count) {
		this.donate_count = donate_count;
	}
	public String getWallet_address() {
		return wallet_address;
	}
	public void setWallet_address(String wallet_address) {
		this.wallet_address = wallet_address;
	}
	public long getTarget_amount() {
		return target_amount;
	}
	public void setTarget_amount(long target_amount) {
		this.target_amount = target_amount;
	}
	public long getNow_amount() {
		return now_amount;
	}
	public void setNow_amount(long now_amount) {
		this.now_amount = now_amount;
	}
	public long getLast_amount() {
		return last_amount;
	}
	public void setLast_amount(long last_amount) {
		this.last_amount = last_amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
	public int getFoundation_id() {
		return foundation_id;
	}
	public void setFoundation_id(int foundation_id) {
		this.foundation_id = foundation_id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}
	public long getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(long begin_time) {
		this.begin_time = begin_time;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", foundation_id=" + foundation_id + ", foundation_name="
				+ foundation_name + ", level=" + level + ", begin_time=" + begin_time + ", end_time=" + end_time
				+ ", audit_status=" + audit_status + ", description=" + description + ", target_amount=" + target_amount
				+ ", now_amount=" + now_amount + ", last_amount=" + last_amount + ", wallet_address=" + wallet_address
				+ ", comment_count=" + comment_count + ", donate_count=" + donate_count + ", img=" + img + "]";
	}

}
