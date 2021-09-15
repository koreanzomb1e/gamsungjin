package com.gamsungjin.main.domain;

import java.util.List;

import com.gamsungjin.board.model.Board;
import com.gamsungjin.post.model.Post;

public class Content {
	// 전체게시판
	private List<Board> boardList;
	// 전체글목록
	private List<Post> postList;
	// 선택된 게시판 글목록
	private List<Post> postBoardList;
	// 선택된 게시판
	private Board board;
	// 포스트 카운트
	private int postCount;
	// 댓글 카운트
	private int commentCount;
	
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public List<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
	public List<Post> getPostList() {
		return postList;
	}
	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
	public List<Post> getPostBoardList() {
		return postBoardList;
	}
	public void setPostBoardList(List<Post> postBoardList) {
		this.postBoardList = postBoardList;
	}
}
