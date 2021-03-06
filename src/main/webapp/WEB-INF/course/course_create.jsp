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
						alert("?????? ????????? ??????????????????.")
						return false;
					}
					if(!timeChk){
						alert("????????? ??????????????????.")
						return false;
					}
					if(!regionChk){
						alert("????????? ??????????????????.")
						return false;
					}
					if(!themeChk){
						alert("????????? ??????????????????.")
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
							<h1>?????? ????????????</h1>

							<!-- Form -->
								<section>
									<form name="form" action = "<c:url value='/course/course_create'/>" method="POST">
										<div class="row gtr-uniform">
											<div class="col-6 col-12-xsmall">
												<input type="text" name="course_name" id="course_name" placeholder="?????? ??????" required/>
											</div>
											<div class="col-6 col-12-xsmall">
											<c:if test="${registerFailed}">
								     			 <font color="red"><c:out value="${exception.getMessage()}" /></font>
								    		</c:if>
											</div><br>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="departure" id="departure" placeholder="?????????" />
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="stopover" id="stopover" placeholder="?????????" />
											</div>
											<div class="col-6 col-12-xsmall">
												<input type="text" name="destination" id="destination" placeholder="?????????" />
											</div><br>
											<div class="col-6 col-12-xsmall"> ?????? ??????
												<label>
								        			<input type="checkbox" name="parking" placeholder="?????? ??????" />
								            		<span class="icon-box">??????</span>
								        		</label>
											</div><br>
											<div class="col-12">??????(1?????? ??????)
												<label>
								        			<input type="checkbox" name="time" value="10???" required />
								            		<span class="icon-box">10???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="15???"/>
								            		<span class="icon-box">15???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="20???"/>
								            		<span class="icon-box">20???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="25???"/>
								            		<span class="icon-box">25???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="30???"/>
								            		<span class="icon-box">30???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="35???"/>
								            		<span class="icon-box">35???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="40???"/>
								            		<span class="icon-box">40???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="45???"/>
								            		<span class="icon-box">45???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="50???"/>
								            		<span class="icon-box">50???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="55???"/>
								            		<span class="icon-box">55???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="time" value="60???"/>
								            		<span class="icon-box">60???</span>
								        		</label>
											
											<div class="col-12"> ??????(1?????? ??????)
												<label>
								        			<input type="checkbox" name="region_id" value="1" required />
								            		<span class="icon-box">??????/??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="2"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="3"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="4"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="5"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="6"/>
								            		<span class="icon-box">??????/??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="7"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="8"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="9"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="10"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="11"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="12"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="13"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="14"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="region_id" value="15"/>
								            		<span class="icon-box">??????</span>
								        		</label>
											</div>
				
												<div class="col-12"> ?????? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<label>
								        			<input type="checkbox" name="themeIdList" value="14"/>
								            		<span class="icon-box">??????</span>
								        		</label>
												<label>
								        			<input type="checkbox" name="themeIdList" value="1" required/>
								            		<span class="icon-box">?????????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="2"/>
								            		<span class="icon-box">?????????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="3"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="4"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="5"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="6"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="7"/>
								            		<span class="icon-box">???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="8"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="9"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="10"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="11"/>
								            		<span class="icon-box">??????</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="12"/>
								            		<span class="icon-box">???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="13"/>
								            		<span class="icon-box">???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="15"/>
								            		<span class="icon-box">???</span>
								        		</label>
								        		<label>
								        			<input type="checkbox" name="themeIdList" value="16"/>
								            		<span class="icon-box">??????</span>
								        		</label>
											</div><br>
											<br>?????? url:<input name='url' type='text'/><br/>
								
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
