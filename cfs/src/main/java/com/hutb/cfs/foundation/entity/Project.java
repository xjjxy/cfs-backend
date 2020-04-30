package com.hutb.cfs.foundation.entity;

public class Project {
	
	private int id;
	private String name;
	private int foundation_id;
	private int level;
	private String begin_time;
	private int duration;
	private String status;
	private String description;
	private long target_amount;
	private long now_amount;
	private long last_amount;
	private String wallet_address;
	
	
	
	
	
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
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", foundation_id=" + foundation_id + ", level=" + level
				+ ", begin_time=" + begin_time + ", duration=" + duration + ", status=" + status + ", description="
				+ description + ", target_amount=" + target_amount + ", now_amount=" + now_amount + ", last_amount="
				+ last_amount + ", wallet_address=" + wallet_address + "]";
	}
	
	
}
