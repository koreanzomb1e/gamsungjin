package com.gamsungjin.comment.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gamsungjin.comment.model.Comment;

@Repository
public interface CommentDAO {
	
	public int getCommentCountByUserId(int userId);
	
	public List<Comment> selectCommentListByPostId(int postId);

	public void deleteCommentByPostId(int postId);
}
