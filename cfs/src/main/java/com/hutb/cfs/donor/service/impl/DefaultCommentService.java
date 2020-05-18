package com.hutb.cfs.donor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutb.cfs.donor.dao.CommentDao;
import com.hutb.cfs.donor.entity.Comment;
import com.hutb.cfs.donor.service.CommentService;

@Service
public class DefaultCommentService implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public int addComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDao.updateCommentCount(comment.getProject_id());
		return commentDao.addComment(comment);
	}

	@Override
	public List<Comment> getCommentByProjectId(int project_id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByProjectId(project_id);
	}

	@Override
	public List<Comment> getCommentByCommentatorId(int commentator_id) {
		// TODO Auto-generated method stub
		return commentDao.getCommentByCommentatorId(commentator_id);
	}

	@Override
	public int deleteComment(int id) {
		// TODO Auto-generated method stub
		return commentDao.deleteComment(id);
	}

}
