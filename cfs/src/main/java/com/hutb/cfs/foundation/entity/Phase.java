package com.hutb.cfs.foundation.entity;

public class Phase {
	
	private int project_id;
	private long phase_time;
	private String phase_title;
	private String phase_description;
	private int phase_spend;
	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	
	public long getPhase_time() {
		return phase_time;
	}
	public void setPhase_time(long phase_time) {
		this.phase_time = phase_time;
	}
	public String getPhase_title() {
		return phase_title;
	}
	public void setPhase_title(String phase_title) {
		this.phase_title = phase_title;
	}
	public String getPhase_description() {
		return phase_description;
	}
	public void setPhase_description(String phase_description) {
		this.phase_description = phase_description;
	}
	public int getPhase_spend() {
		return phase_spend;
	}
	public void setPhase_spend(int phase_spend) {
		this.phase_spend = phase_spend;
	}
	@Override
	public String toString() {
		return "Phase [project_id=" + project_id + ", phase_time=" + phase_time + ", phase_title=" + phase_title
				+ ", phase_description=" + phase_description + ", phase_spend=" + phase_spend + "]";
	}
	
	
	

}
