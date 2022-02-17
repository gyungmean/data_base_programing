<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Phantom by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>course_matching</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="<c:url value='/drive_course_matching/assets/css/main.css' />" />
		<noscript><link rel="stylesheet" href="<c:url value='/drive_course_matching/assets/css/noscript.css' />" /></noscript>
	</head>
	<body class="is-preload">
		<!-- Scripts -->
			<script src="<c:url value='/drive_course_matching/assets/js/jquery.min.js'/>"></script>
			<script src="<c:url value='/drive_course_matching/assets/js/browser.min.js'/>"></script>
			<script src="<c:url value='/drive_course_matching/assets/js/breakpoints.min.js'/>"></script>
			<script src="<c:url value='/drive_course_matching/assets/js/util.js'/>"></script>
			<script src="<c:url value='/drive_course_matching/assets/js/main.js'/>"></script>
			<script>
				course_matching = function(targetUri) {
					form.action = targetUri;
					form.method="POST";
					form.submit();
				}
				course_detail = function(targetUri) {
					form.action = targetUri;
					form.method="POST";
					form.submit();
				}
				likeCreate = function(targetUri) {
					alert('likeCreate 눌림');
		 			<!--document.createElement('like').setAttribute('user_id', 1);-->
		 			form.action = targetUri;
		 			form.method="POST";
		 			form.submit();
		 		}
			</script>
			
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">

							<!-- Logo -->
								<a href="<c:url value='/main'/>" class="logo">
									<span class="symbol"></span><span class="title">Main</span>
								</a>

						</div>
					</header>

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<h1 style="display:inline">
								<c:set var="controller" value="${controller}" />
								<c:choose>
								    <c:when test="${controller eq 'List'}">
								        #지역의 #테마 코스 둘러보기 
								    </c:when>
								    <c:when test="${controller eq 'Match'}">
								    	#${region}의&nbsp;
								        <c:forEach var="theme" items="${themeList}">
												#${theme}&nbsp;
										</c:forEach>
										코스 둘러보기
								    </c:when>
								</c:choose>
								
								</h1>
								<details>
									<summary>키워드 선택</summary>
									<br>
									<form name="form" action = "<c:url value='/course/course_matching'/>" method="POST">
									<div class="wrap-keyword">
										<div class="time-wrap">
											<div class="title">시간(1개만 선택)</div>
											<div class="row">
								        		<label>
								        			<input type="checkbox" name="time" value="10분" />
								            		<span class="icon-box">10분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="15분"/>
								            		<span class="icon-box">15분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="20분"/>
								            		<span class="icon-box">20분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="25분"/>
								            		<span class="icon-box">25분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="30분"/>
								            		<span class="icon-box">30분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="35분"/>
								            		<span class="icon-box">35분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="40분"/>
								            		<span class="icon-box">40분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="45분"/>
								            		<span class="icon-box">45분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="50분"/>
								            		<span class="icon-box">50분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="55분"/>
								            		<span class="icon-box">55분</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="60분"/>
								            		<span class="icon-box">60분</span>
								        		</label>
								      		</div>
										</div>
										<div class="region-wrap">
											<div class="title">선호지역(1개만선택)</div>
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
						      				</div>
										</div>
									</div>
									<input type="button" onClick="course_matching('<c:url value='/course/course_matching'/>')" value="매칭">
									</form>
								</details>
							</header>
							<br>
							<form>
							<section class="tiles">
							 <c:forEach var="course" items="${courseList}">  	
								<article class="style6">
									<span class="image">
										<img src="${course.url}" width="200" height="200" alt="" />
									</span>
									
									<a href="<c:url value='/course/course_detail'>
									<c:param name='course_id' value='${course.course_id}'/>
			 		 				</c:url>">
										<h2>${course.course_name}</h2>
										<div class="content">
											<p>
											<c:forEach var="theme" items="${course.themeList}">
												#${theme.theme_name}&nbsp;
											</c:forEach>
											
											</p>
											
										</div>
									</a>
									
								</article>
							</c:forEach>
							</section>
							</form>
						</div>
					</div>

			</div>

	</body>
</html>