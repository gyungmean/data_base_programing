<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int user_id = (int)(request.getAttribute("user_id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>선호키워드 선택</title>
	<link rel="stylesheet" 
	href="<c:url value = '/course_keyword_select/style.css' />">
</head>
<body>
 <script>
	userCreate = function() {
		form.method="POST";		// register form 요청
		form.submit();
	}
	</script>
	<div class="wrap">
		<div class="txt"><h2>선호 키워드 선택</h2></div>
		<form name="form" action="<c:url value='/user/selectKeyword'/>" id="form">
		<div class="txt">
			<input type="submit" class = "button" onclick="userCreate()" value = "다음에 할게요">
			<input type="submit" class = "button" onclick="userCreate()" value = "확인"> 
		</div>
		<div class="wrap-keyword">
			<div class="region-wrap">
				<div class="title">선호지역</div>
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
			<div class="title">선호테마</div>
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
        		<input type="hidden" name="user_id" value="<%=user_id%>"> 
      		</div>
		</div>
		</div>
	</form>
	</div>	
</body>
</html>