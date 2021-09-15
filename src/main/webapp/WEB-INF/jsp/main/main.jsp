<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="d-flex">
	<!-- 전체글보기 -->
	<div class="w-50 ml-3">
		<h2>전체글보기</h2>
		
		<table class="table">
			<c:forEach var="post" items="${content.postList}">
				<tr>
					<td>${post.subject}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<!-- 공지사항, 사진게시판 -->
	<div class="w-50 ml-3">
		<!-- 공지사항 -->
		<div class="h-50">
			<h2>공지사항</h2>
			
			<table class="table">
				<c:forEach var="postNotice" items="${content.postBoardList}">
					<tr>
						<td>${postNotice.subject}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- 사진게시판 -->
		<div class="h-50">
			<h2>사진게시판</h2>
			
			<table class="table">
				<c:forEach var="postImage" items="${content.postBoardList}">
					<tr>
						<td>${postImage.subject}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>