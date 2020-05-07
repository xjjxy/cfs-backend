package com.hutb.cfs.donor.entity;

public class Donation {
	

	private int id;
	private int donor_id;
	private String donor_name;
	private int foundation_id;
	private String foundation_name;
	private int project_id;
	private String project_name;
	private int donate_amount;
	private long donate_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDonor_id() {
		return donor_id;
	}
	public void setDonor_id(int donor_id) {
		this.donor_id = donor_id;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public int getFoundation_id() {
		return foundation_id;
	}
	public void setFoundation_id(int foundation_id) {
		this.foundation_id = foundation_id;
	}
	public String getFoundation_name() {
		return foundation_name;
	}
	public void setFoundation_name(String foundation_name) {
		this.foundation_name = foundation_name;
	}
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public int getDonate_amount() {
		return donate_amount;
	}
	public void setDonate_amount(int donate_amount) {
		this.donate_amount = donate_amount;
	}
	public long getDonate_time() {
		return donate_time;
	}
	public void setDonate_time(long donate_time) {
		this.donate_time = donate_time;
	}
	@Override
	public String toString() {
		return "Donation [id=" + id + ", donor_id=" + donor_id + ", donor_name=" + donor_name + ", foundation_id="
				+ foundation_id + ", foundation_name=" + foundation_name + ", project_id=" + project_id
				+ ", project_name=" + project_name + ", donate_amount=" + donate_amount + ", donate_time=" + donate_time
				+ "]";
	}
	
	
}
