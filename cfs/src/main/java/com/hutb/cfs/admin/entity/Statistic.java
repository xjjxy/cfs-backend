package com.hutb.cfs.admin.entity;

public class Statistic {

	private int foundation_count;
	private int foundation_user_count;
	private int project_count;
	private long donor_count;
	private long donate_count;
	private long amount_count;
	public int getFoundation_count() {
		return foundation_count;
	}
	public void setFoundation_count(int foundation_count) {
		this.foundation_count = foundation_count;
	}
	public int getFoundation_user_count() {
		return foundation_user_count;
	}
	public void setFoundation_user_count(int foundation_user_count) {
		this.foundation_user_count = foundation_user_count;
	}
	public int getProject_count() {
		return project_count;
	}
	public void setProject_count(int project_count) {
		this.project_count = project_count;
	}
	public long getDonor_count() {
		return donor_count;
	}
	public void setDonor_count(long donor_count) {
		this.donor_count = donor_count;
	}
	public long getDonate_count() {
		return donate_count;
	}
	public void setDonate_count(long donate_count) {
		this.donate_count = donate_count;
	}
	public long getAmount_count() {
		return amount_count;
	}
	public void setAmount_count(long amount_count) {
		this.amount_count = amount_count;
	}
	@Override
	public String toString() {
		return "Statistic [foundation_count=" + foundation_count + ", foundation_user_count=" + foundation_user_count
				+ ", project_count=" + project_count + ", donor_count=" + donor_count + ", donate_count=" + donate_count
				+ ", amount_count=" + amount_count + "]";
	}
	
	
}
