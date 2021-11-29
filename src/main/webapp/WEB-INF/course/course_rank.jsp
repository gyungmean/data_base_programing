<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<c:url value='/drive_course_rank/font-awesome.min.css' />">
    <link rel="stylesheet" href="<c:url value='/drive_course_rank/style.css' />">
    <title>베스트 드라이브 코스</title>
  </head>
<body>
<div class="wrap">
<div>
<a href="<c:url value='/main'/>" class="logo">
	<i class="fa fa-home" aria-hidden="true" style="color:#00B4CC;font-size:20px;"></i>
	<br><br>
</a>
</div>
<form name="search" action="<c:url value='/course/search_result' />" method="GET" >
   <div class="search">
   
      <input type="text" class="searchTerm" name="search_word" placeholder="코스 이름을 입력하세요.">
      <button type="submit" class="searchButton">
        <i class="fa fa-search"></i>
     </button>

   </div>
</form>
   <div class="text">
   	<div></div>
   	<h1><i class="fa fa-trophy" style="color: #00B4CC;"></i> 베스트 드라이브 코스</h1>
   </div>
   <div class="top20">
   	<!-- 랭킹 출력 -->
   	<ol class="rounded-list">
   		<c:forEach var="resultList" items="${resultList}">
   		<li>
   			<a href="<c:url value='/course/course_detail'>
							<c:param name='course_id' value='${resultList.key.course_id}'/>
			 		</c:url>">
   				<span class="course-name">${resultList.key.course_name}</span><br>
   				<i class="fa fa-heart" aria-hidden="true" style="color:#ff0000;"></i> ${resultList.value}
   				<c:forEach var="theme" items="${resultList.key.themeList}">
					#${theme.theme_name}&nbsp;
				</c:forEach>
				#${resultList.key.time}
   			</a>
   		</li>  	
		</c:forEach>                       
    </ol>
	    
   </div>
</div>

</body>
</html>