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
		<title>검색결과</title>
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
			</script>
			
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">

							<!-- Logo -->
								<a href="<c:url value='/course/course_rank'/>" class="logo">
									<span class="symbol"></span><span class="title">Back</span>
								</a>

						</div>
					</header>

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<header>
								<h1 style="display:inline">
									'${search_word}'의 검색결과
								</h1>
							</header>
							<br>
							<section class="tiles">
							 <c:forEach var="course" items="${courseList}">  	
								<article class="style6">
									<span class="image">
										<img src="<c:url value='/drive_course_matching/images/pic06.jpg'/>" alt="" />
									</span>
									<a href="<c:url value='/drive_course_matching/generic.html'/>">
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
						</div>
					</div>

			</div>

	</body>
</html>