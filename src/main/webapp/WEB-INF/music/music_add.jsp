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
		<title>music_add</title>
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
				music_add = function() {
					var musicTitle = document.form.musicTitle.value;
					var musicUrl = document.form.musicUrl.value;
					var musicTag = document.form.musicTag.value;
				   
				    	   
					if(!musicTitle){
						alert("뮤직리스트 이름을 입력해주세요.")
						return false;
					}
					if(!musicUrl){
						alert("URL을 입력해주세요.")
						return false;
					}
					if(!musicTag){
						alert("태그를 입력해주세요.")
						return false;
					}
					else{
						form.method="POST";
						form.submit();
						return true;
					}
				}
			</script>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
					<header id="header">
						<div class="inner">

							<!-- Logo -->
								<a href="<c:url value='/main'/>" class="logo">
									<span class="symbol"></span><span class="title">main</span>
								</a>
						</div>
					</header>

				<!-- Main -->
					<div id="main">
						<div class="inner">
							<h1>MusicList 등록하기</h1>

							<!-- Form -->
								<section>
									<form name="form" action = "<c:url value='/music/add'/>" method="post" >
										<div class="row gtr-uniform">
											<div class="col-6 col-12-xsmall">
												<input type="text" name="musicTitle" id="musicTitle" placeholder="뮤직리스트 이름" required/>
											</div>
											<br>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="musicUrl" id="musicUrl" placeholder="URL" />
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="musicTag" id="musicTag" placeholder="Tag" />
											</div>
											<br>
											
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" onClick="return music_add()" value="Create" class="primary" /></li>
													<li><input type="reset" value="Reset" /></li>
												</ul>
											</div>
										</div>
										
									</form>
									 
								</section>


						</div>
					</div>


			</div>


	</body>
