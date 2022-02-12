<%@ page import="model.*" %>
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
		<title>music_list</title>
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
				music_find = function(targetUri) {
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
								        Music List 
								    </c:when>
								    <c:when test="${controller eq 'Search'}">
								    	#${tag}의&nbsp; Music List
								    </c:when>
								</c:choose>
								
								</h1>
								<details>
									<summary>키워드 검색</summary>
									<br>
									<form name="form" action = "<c:url value='/music/find'/>" method="POST">
										   <div class="search">
										   	<input type="text" class="searchTerm" name="search_word" placeholder="테마 이름을 입력하세요.">
										      <input type="button" onClick="music_find('<c:url value='/music/find'/>')" value="검색">
										  </div>
									</form>
									</details>
									<button type="button" onclick="location.href='<c:url value='/music/form'/>' ">뮤직 리스트 등록하기</button>
							</header>
							<br>
							<form>
							<section class="tiles">
							 <c:forEach var="music" items="${musicList}">  	
								<article class="style6">
									<span class="image">
									<iframe width="400" height="250" src="${music.musicUrl}" title="YouTube video player" frameborder="0" allow="accelerometer; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
									
									</span>
										<h3>${music.musicTitle}</h3>
										<div class="content">
											${music.musicTag}&nbsp;
										</div>
								
								</article>
							</c:forEach>
							</section>
							</form>
						</div>
					</div>

			</div>

	</body>
</html>