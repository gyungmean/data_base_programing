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
		<title>course_create</title>
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
				course_create = function() {
					var course_name = document.form.course_name.value;
					
					var timeChk = false;
				       var arr_time = document.getElementsByName("time");
				       for(var i=0; i<arr_time.length;i++){
				           if(arr_time[i].checked == true) {
				               timeChk = true;
				               break;
				           }
				       }
				       
				       var regionChk = false;
				       var arr_region = document.getElementsByName("region_id");
				       for(var i=0; i<arr_region.length;i++){
				           if(arr_region[i].checked == true) {
				               regionChk = true;
				               break;
				           }
				       }
				       
				       var themeChk = false;
				       var arr_theme = document.getElementsByName("themeIdList");
				       for(var i=0; i<arr_theme.length;i++){
				           if(arr_theme[i].checked == true) {
				        	   themeChk = true;
				               break;
				           }
				       }
					if(!course_name){
						alert("코스 이름을 입력해주세요.")
						return false;
					}
					if(!timeChk){
						alert("시간을 선택해주세요.")
						return false;
					}
					if(!regionChk){
						alert("지역을 선택해주세요.")
						return false;
					}
					if(!themeChk){
						alert("테마를 선택해주세요.")
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
							<h1>코스 생성하기</h1>

							<!-- Form -->
								<section>
									<form name="form" action = "<c:url value='/course/course_create'/>" method="POST">
										<div class="row gtr-uniform">
											<div class="col-6 col-12-xsmall">
												<input type="text" name="course_name" id="course_name" placeholder="코스 이름" required/>
											</div>
											<div class="col-6 col-12-xsmall">
											<c:if test="${registerFailed}">
								     			 <font color="red"><c:out value="${exception.getMessage()}" /></font>
								    		</c:if>
											</div><br>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="departure" id="departure" placeholder="출발지" />
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="stopover" id="stopover" placeholder="경유지" />
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="destination" id="destination" placeholder="도착지" />
											</div><br>
											<div class="col-6 col-12-xsmall"> 주차 장소
												<label>
								        			<input type="checkbox" name="parking" placeholder="주차 장소" />
								            		<span class="icon-box">있음</span>
								        		</label>
											</div><br>
											<div class="col-12">시간(1개만 선택)
												<label>
								        			<input type="checkbox" name="time" value="10분" required />
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
											
											<div class="col-12"> 지역(1개만 선택)
												<label>
								        			<input type="checkbox" name="region_id" value="1" required />
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
				
												<div class="col-12"> 테마 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<label>
								        			<input type="checkbox" name="themeIdList" value="14"/>
								            		<span class="icon-box">가족</span>
								        		</label>
												<label>
								        			<input type="checkbox" name="themeIdList" value="1" required/>
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
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="15"/>
								            		<span class="icon-box">강</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="16"/>
								            		<span class="icon-box">맛집</span>
								        		</label>
											</div><br>
											<br>사진 url:<input name='url' type='text'/><br/>
								
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" onClick="return course_create()" value="Create" class="primary" /></li>
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
