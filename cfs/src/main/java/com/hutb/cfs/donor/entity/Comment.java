package com.hutb.cfs.donor.entity;

public class Comment {
	private int id;
	private int project_id;
	private String project_name;
	private int commentator_id;
	private String commentator_name;
	private long comment_time;
	private String comment;
	
	
	public long getComment_time() {
		return comment_time;
	}
	public void setComment_time(long comment_time) {
		this.comment_time = comment_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	public int getCommentator_id() {
		return commentator_id;
	}
	public void setCommentator_id(int commentator_id) {
		this.commentator_id = commentator_id;
	}
	public String getCommentator_name() {
		return commentator_name;
	}
	public void setCommentator_name(String commentator_name) {
		this.commentator_name = commentator_name;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", project_id=" + project_id + ", project_name=" + project_name
				+ ", commentator_id=" + commentator_id + ", commentator_name=" + commentator_name + ", comment_time="
				+ comment_time + ", comment=" + comment + "]";
	}

	
}
