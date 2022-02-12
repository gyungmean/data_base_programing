<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.*" %>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.SimpleDateFormat" %>
<%@ page import ="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 화면 최적화 -->
<meta name="viewport" content="width-device-width", initial-scale="1">
<!-- 루트 폴더에 부트스트랩을 참조하는 링크 -->
<link rel="stylesheet" href="<c:url value='/comments_list/css/bootstrap.css' />">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
	Comment comment = (Comment)request.getAttribute("comment");
	User user = (User)request.getAttribute("user");
	

	Long cmtNo = comment.getCommentNo();
	
	Date day = comment.getRegDate(); 
	
	//현재날짜 / 시간을 출력할 수 있음 //문자열을로 바꾸고 싶으면 String 객체에 toString으로 담아주면됨. 
	SimpleDateFormat fDay = new SimpleDateFormat("yyyy년 MM월  dd일 a HH:mm:ss"); 
	String sfDay = fDay.format(day); 


	String cmt = comment.getCommentContent();
	String title = comment.getTitle();
	
	int courseId = comment.getCourseId();
	
	
	%>
	
	<!-- 게시판 글 보기 양식 영역 시작 -->
	<div class="container">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글 보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">글 제목</td>
						<td colspan="2"><%=title.replaceAll(" ", "&nbsp;")
								.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%=user.getNickname()%></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%=sfDay%></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="height: 200px; text-align: left;"><%= cmt.replaceAll(" ", "&nbsp;")
							.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>") %></td>
					</tr>
				</tbody>
			</table>
			<form name = "replyForm" method="Post" action = "<c:url value='/comments/view'/>">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<%-- 홀,짝 행 구분 --%>
					<thead>
						<tr>
							<th colspan="3"
								style="background-color: #eeeeeee; text-align: center;">댓글</th>
						</tr> 
					</thead>
					<tbody>
						<c:forEach var="reply" items="${replyList}">  
						<tr>
							<td style="text-align: left;">${reply.replyContent}</td>
							<td style="text-align: right;">${reply.nickname}</td>
						
						</tr>
						</c:forEach>
						<td>
						<textarea type="text" class="form-control"
								placeholder="댓글을 입력하세요." name="replyContent" maxlength="2048"></textarea></td>
						<td style="text-align: left; "></td>
					
					</tbody>
		
				</table>
				
				<input type = "hidden" name = "commentNo" value = "<%=comment.getCommentNo()%>">
				<input type="hidden" name="user_id" value="<%=user.getUser_id()%>">
				<c:if test="${user.user_id ne -1}"> 
				<input type="submit" class="btn" value="댓글입력">
				</c:if>
			</form>
			<br>
			<a href="bbs.jsp" class="btn btn-primary">목록</a>
			

		</div>
	</div>
	<!-- 게시판 글 보기 양식 영역 끝 -->
	
	
	<!-- 부트스트랩 참조 영역 -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>