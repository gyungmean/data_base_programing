<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<c:url value='/drive_course_rank/font-awesome.min.css' />">
    <link rel="stylesheet" href="<c:url value='/drive_course_rank/style.css' />">
    <title>my page</title>
  </head>
<body>
<div class="wrap">
<div class="search-wrap">
	<a href="<c:url value='/main'/>" class="logo">
		<i class="fa fa-home" aria-hidden="true" style="color:#00B4CC;font-size:20px;"></i>
		<br><br>
	</a>
</div>
<div class="info-wrap">
   <div class="text">
   <br><br>
   	<i class="fa fa-user-circle" style="color: #00B4CC;font-size: 100px"></i>
   	<h1><i class="fa fa-id-card-o" aria-hidden="true" style="color:#00B4CC;"></i> 회원 정보</h1>
   	<h3>닉네임​&nbsp;​&nbsp;​&nbsp;​&nbsp;${userNickname}</h3>
   	<details>
    <summary>닉네임 수정하기</summary>
    <form name="nickname" action="<c:url value='/user/info' />" method="POST">
		<input type="text" name="newNickname" class="nickname">​&nbsp;<button type="submit" class="nicknameButton"><i class="fa fa-check" aria-hidden="true"></i></button>
    	<input type="hidden" name="formName" value="changeNickName">
    </form>
    </details>
   	
   	<h3>이메일​&nbsp;​&nbsp;​&nbsp;​&nbsp;${email}</h3>
   	<br>
   	<h1><i class="fa fa-tags" aria-hidden="true" style="color:#00B4CC;"></i> 선호 키워드</h1>
   	<h3>선호 지역&nbsp;​&nbsp;​&nbsp;​&nbsp;
   	<c:forEach var="regionList" items="${regionList}">
   	#${regionList.region_name}&nbsp;
   	</c:forEach>
   	</h3>
   	<h3>선호 테마​&nbsp;​&nbsp;​&nbsp;​&nbsp;
   	<c:forEach var="themeList" items="${themeList}">
   	#${themeList.theme_name}&nbsp;
   	</c:forEach>
   	</h3>
   	<details>
    <summary>선호 키워드 수정하기</summary>
    <br>
    <form name="keyWord" action="<c:url value='/user/info' />" method="POST">
    <button type="submit" class="keyWordButton">수정하기</button>
    <br><br>
    <input type="hidden" name="formName" value="changeKeyWord">
    <div class="wrap-keyword">
			<div class="region-wrap">
				<div class="title">선호지역<br></div>
				<div class="row">
	        		<label>
	        			<input type="checkbox" name="region_id" value="1" />
	            		<span class="icon-box">서울/경기</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="2"/>
	            		<span class="icon-box">인천</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="3"/>
	            		<span class="icon-box">강원</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="4"/>
	            		<span class="icon-box">충북</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="5"/>
	            		<span class="icon-box">충남</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="6"/>
	            		<span class="icon-box">대전/세종</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="7"/>
	            		<span class="icon-box">전북</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="8"/>
	            		<span class="icon-box">전남</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="9"/>
	            		<span class="icon-box">광주</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="10"/>
	            		<span class="icon-box">경북</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="11"/>
	            		<span class="icon-box">경남</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="12"/>
	            		<span class="icon-box">대구</span>
	        		</label>
	        	    <label>
	        			<input type="checkbox" name="region_id" value="13"/>
	            		<span class="icon-box">울산</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="14"/>
	            		<span class="icon-box">부산</span>
	        		</label>
	        		<label>
	        			<input type="checkbox" name="region_id" value="15"/>
	            		<span class="icon-box">제주</span>
	        		</label>
	      		</div>
			</div>
			<div class="theme-wrap">
			<div class="title">선호테마<br></div>
			<div class="row">
        		<label>
        			<input type="checkbox" name="themeIdList" value="1"/>
            		<span class="icon-box">데이트</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="2"/>
            		<span class="icon-box">친구들</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="3"/>
            		<span class="icon-box">바다</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="4"/>
            		<span class="icon-box">도심</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="5"/>
            		<span class="icon-box">야경</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="6"/>
            		<span class="icon-box">힐링</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="7"/>
            		<span class="icon-box">봄</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="8"/>
            		<span class="icon-box">여름</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="9"/>
            		<span class="icon-box">가을</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="10"/>
            		<span class="icon-box">겨울</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="11"/>
            		<span class="icon-box">호수</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="12"/>
            		<span class="icon-box">숲</span>
        		</label>
        		<label>
        			<input type="checkbox" name="themeIdList" value="13"/>
            		<span class="icon-box">산</span>
        		</label>
      		</div>
		</div>
		</div>
		</form>
    </details>
   	<br>
   	<h1><i class="fa fa-heart" aria-hidden="true" style="color:#00B4CC;"></i> 좋아요 한 코스</h1>
    	<ul class="ul-rounded-list">
   		<c:forEach var="course" items="${likeCourseList}">
   		<li>
   			<a href="<c:url value='/course/course_detail'>
							<c:param name='course_id' value='${course.course_id}'/>
			 		</c:url>">
   				<span class="course-name">${course.course_name}</span><br>
   				<c:forEach var="theme" items="${course.themeList}">
												#${theme.theme_name}&nbsp;
				</c:forEach>
   			</a>
   		</li>  	
		</c:forEach>                       
    	</ul>
   	<br>
   	<h1><i class="fa fa-pencil-square-o" aria-hidden="true" style="color:#00B4CC;"></i> 내가 작성한 글</h1>
   	<h3>내가 작성한 드라이브 코스</h3>
   	<ul class="ul-rounded-list">
   		<c:forEach var="course" items="${writeCourseList}">
   		<li>
   			<a href="<c:url value='/course/course_detail'>
							<c:param name='course_id' value='${course.course_id}'/>
			 		</c:url>">
   				<span class="course-name">${course.course_name}</span><br>
   				<c:forEach var="theme" items="${course.themeList}">
												#${theme.theme_name}&nbsp;
				</c:forEach>
   			</a>
   		</li>  	
		</c:forEach>                       
    </ul>
    <h3>내가 작성한 맛집</h3>
   	<ul class="ul-rounded-list">
   		<c:forEach var="comment" items="${writeCommentsList}">
   		<li>
   			<a href="<c:url value='/comments/view'>
							<c:param name='commentNo' value='${comment.commentNo}'/>
			 		</c:url>">
   				<span class="course-name">${comment.title}</span><br>
   			</a>
   		</li>  	
		</c:forEach>                       
    </ul>
   </div>
   
</div>
</div>

</body>
</html>