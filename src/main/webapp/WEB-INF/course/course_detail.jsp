<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Course course = (Course)request.getAttribute("course");
	User user = (User)request.getAttribute("user");
	
	int like_count = (int)(request.getAttribute("like_count"));
	
	String departure = course.getDeparture();
	String stopover = course.getStopover();
	String destination = course.getDestination();
	if(departure == null)
		departure = "X";
	if(stopover == null)
		stopover = "X";
	if(destination == null)
		destination = "X";
	
	String region_name = (String)(request.getAttribute("region_name"));
	
	int getParking = course.getParking();
	String parking = "";
	if(getParking == 1)
		parking = "있음";
	else
		parking = "없음";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="EUC-KR">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>코스 상세페이지</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/blog/">

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
    @import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 7rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="drive_course_detail/blog.css" rel="stylesheet">
</head>
<body>
<script>
 		likeCreate = function() {
 			<!--document.createElement('like').setAttribute('user_id', 1);-->
 			like.method="POST";
 			like.submit();
 		}
 	</script>
<div class="container" align = "center">
  <header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 pt-1">
        <a class="link-secondary" href="<c:url value='/course' />" style="font-family: 'Do Hyeon', sans-serif;">뒤로 가기</a>
      </div>
      <div class="col-4 text-center">
        <a class="blog-header-logo text-dark" style="font-family: 'Do Hyeon', sans-serif;">
        <font size="15">
        <%=course.getCourse_name()%></font></a>
      </div>
      <div class="col-4 d-flex justify-content-end align-items-center">
        <a class="link-secondary" href="#" aria-label="Search">
        </a>
      </div>
    </div>
  </header>
</div>

<main class="container" align = "center">

<form name="like" id="like" action="<c:url value='/course/course_detail' />">
  <div class="row g-5" align = "center">
    <div class="col-md-8" align = "center">
      <article class="blog-post" align = "center">
      <table class="table" align = "center">
          <tbody align = "center"> 
            <tr>
              <td style="font-family: 'Do Hyeon', sans-serif;"><%=course.getCourse_name()%></td>
              <td style="font-family: 'Do Hyeon', sans-serif;">
              	<c:forEach var="theme1" items="${course.themeList}">
					  #${theme1.theme_name} 
				</c:forEach> 
              </td>
       		  <td style="font-family: 'Do Hyeon', sans-serif;"><%=course.getTime()%></td>
       		  <td style="font-family: 'Do Hyeon', sans-serif;">♥<%=like_count%></td>
            </tr>
          </tbody>
        </table>
        <table class="table" align = "center">
          <tbody>
            <tr>
              <td style="font-family: 'Do Hyeon', sans-serif;">경로</td>
              <td style="font-family: 'Do Hyeon', sans-serif;">
              	출발지:<%=departure%>     경유지:<%=stopover%>     도착지:<%=destination%>
              </td>
            </tr>
            <tr>
              <td style="font-family: 'Do Hyeon', sans-serif;">지역</td>
              <td style="font-family: 'Do Hyeon', sans-serif;"><%=region_name%></td>
            </tr>
            <tr>
              <td style="font-family: 'Do Hyeon', sans-serif;">주차할 만한 곳</td>
              <td style="font-family: 'Do Hyeon', sans-serif;"><%=parking%></td>
            </tr>
          </tbody>
        </table>
      </article>
      <input type="hidden" name="course_id" value="<%=course.getCourse_id()%>"> 
      <nav class="blog-pagination" aria-label="Pagination">
        <a class="btn btn-outline-primary" onClick="likeCreate()" style="font-family: 'Do Hyeon', sans-serif;">좋아요</a>
        <a class="btn btn-outline-primary" 
        href="<c:url value='/course/course_move'><c:param name='course_id' value='${course.course_id}'/></c:url>"
        style="font-family: 'Do Hyeon', sans-serif;">주변 갈만한 곳</a>
      </nav>
    </div>
  </div>
  </form>
  
</main>
</body>
</html>