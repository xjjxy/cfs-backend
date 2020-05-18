package com.hutb.cfs.donor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hutb.cfs.basedao.BaseDao;
import com.hutb.cfs.donor.entity.Comment;

public interface CommentDao extends BaseDao {
	
	/*
	 * 	private int project_id;
	private String project_name;
	private String comment_name;
	private String comment;
	 */
	
	@Insert("insert into t_cfs_project_comment (project_id,project_name,commentator_id,commentator_name,comment_time,comment) "
			+ "values(#{project_id},#{project_name},#{commentator_id},#{commentator_name},#{comment_time},#{comment})")
	public int addComment(Comment comment);
	
	@Select("select * from t_cfs_project_comment where project_id = #{project_id} order by comment_time desc")
	public List<Comment> getCommentByProjectId(int project_id);
	
	@Select("select * from t_cfs_project_comment where commentator_id = #{commentator_id} order by comment_time desc")
	public List<Comment> getCommentByCommentatorId(int commentator_id);
	
	@Delete("delete from t_cfs_project_comment where id = #{id}")
	public int deleteComment(int id);
	
	
	@Update("update t_cfs_basic_project_info set comment_count = comment_count+1 where id = #{project_id}")
	public int updateCommentCount(int project_id);
	
	

}
