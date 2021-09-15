package com.gamsungjin.main.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamsungjin.board.bo.BoardBO;
import com.gamsungjin.board.model.Board;
import com.gamsungjin.comment.bo.CommentBO;
import com.gamsungjin.main.domain.Content;
import com.gamsungjin.post.bo.PostBO;
import com.gamsungjin.post.model.Post;

@Service
public class ContentBO {
	
	@Autowired
	private BoardBO boardBO;
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private CommentBO commentBO;
	
	/*메인화면*/
	public Content getContent() {
		Content content = new Content();
		
		/*전체글목록*/
		List<Post> postList = postBO.getPostList();
		content.setPostList(postList);
		
		/*공지사항*/
		List<Post> postNoticeList = postBO.getPostBoardList(1);
		content.setPostBoardList(postNoticeList);
		
		/*사진게시판*/
		List<Post> postImageList = postBO.getPostBoardList(7);
		content.setPostBoardList(postImageList);
		
		return content;
	}
	
	/*게시판*/
	public Content getContentByBoardId(int boardId) {
		Content content = new Content();
		
		/*선택된 게시판*/
		Board board = boardBO.getBoardById(boardId);
		content.setBoard(board);
		
		/*선택된 게시판 글목록*/
		List<Post> postList = postBO.getPostBoardList(boardId);
		content.setPostBoardList(postList);
		
		return content;
	}
	
	/* 로그인 상태: 회원정보, 전체게시판 */
	public Content getNavLogin(int userId) {
		Content content = new Content();
		
		/* 전체게시판 */
		List<Board> boardList = boardBO.getBoardList();
		content.setBoardList(boardList);
		
		/* 포스트, 댓글 카운트 */
		int postCount = postBO.getPostCountByUserId(userId);
		content.setPostCount(postCount);
		
		int commentCount = commentBO.getCommentCountByUserId(userId);
		content.setCommentCount(commentCount);
		
		return content;
	}
	
	/* 로그아웃 상태: 전체게시판 */
	public Content getNavLogout() {
		Content content = new Content();
		
		/* 전체게시판 */
		List<Board> boardList = boardBO.getBoardList();
		content.setBoardList(boardList);
		
		return content;
	}
}
