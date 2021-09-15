<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="ml-3">
	<div class="ml-2">
	<!-- 게시판 이름, 글제목, 작성자 닉네임 -->
		<h5>${post.boardName}</h5>
		<h3><b>${post.subject}</b></h3>
		
		<div class="d-flex">
			<img src="http://simpleicon.com/wp-content/uploads/user1.png" alt="user_icon" width="25px" height="25px">
			<h5>${post.nickname}</h5>
		</div>
		
	</div>
	<hr>
	
	<!-- 글내용 -->
	<div>
		${post.content}
	</div>
	<hr>
	
	<!-- 삭제, 수정 버튼 -->
	<!-- 로그인 유저와 글 작성자가 같을 때 -->
	<c:if test="${userId eq post.id}">
		<div class="d-flex justify-content-end">
			<button type="button" class="btn btn-primary mr-2">삭제</button>
			<button type="button" class="btn btn-secondary">수정</button>
		</div>
	</c:if>
	
	<!-- 댓글 -->
	<h5><b>댓글</b></h5>
	<c:forEach var="comment" items="${commentList}">
		<div>
			<img src="http://simpleicon.com/wp-content/uploads/user1.png" alt="user_icon" width="25px" height="25px">
			<span class="mr-5">${comment.nickname}</span>
			<span>${comment.content}</span>
		</div>
	</c:forEach>
	
	<!-- 로그인 상태에서만 댓글쓰기 활성화 -->
	<c:if test="${not empty userId}">
		<div class="input-group mt-2">
			<input type="text" class="form-control" name="content" placeholder="댓글을 입력해주세요.">
			<div class="input-group-append">
				<button type="button" class="btn btn-secondary btn-sm">등록</button>
			</div>
		</div>
	</c:if>
</div>