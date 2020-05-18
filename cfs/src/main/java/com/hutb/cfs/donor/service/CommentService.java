package com.hutb.cfs.donor.service;

import java.util.List;

import com.hutb.cfs.donor.entity.Comment;

public interface CommentService {

	public int addComment(Comment comment);
	
	public List<Comment> getCommentByProjectId(int project_id);
	
	public List<Comment> getCommentByCommentatorId(int commentator_id);
	
	public int deleteComment(int id);
}
