<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	int user_id = (int)(request.getAttribute("userId"));
	String user_nickname = (String)(request.getAttribute("userNickname"));
	System.out.println("jsp userId : " + user_id);
%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
  <style>
		@import url('https://fonts.googleapis.com/css?family=Gugi:400');
		@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
</style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>mainPage</title>
    <link rel="stylesheet" href="driveMain/nicepage.css" media="screen">
<link rel="stylesheet" href="driveMain/mainPage.css" media="screen">
    <script class="u-script" type="text/javascript" src="driveMain/jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="driveMain/nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 3.29.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
}
</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="mainPage">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body">
  <header class="u-clearfix u-header u-header" id="sec-5a17"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-text u-text-1">
        <c:set var="user_id" value="<%=user_id %>"></c:set>
        <c:set var="user_nickname" value="<%=user_nickname %>"></c:set>
        <c:choose>
	        <c:when test="${user_id eq 0}">
		        <a class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-palette-1-dark-1 u-btn-1"
			         href="<c:url value='/user/login/form' />"> 
					  <span class="u-icon u-icon-1"><svg class="u-svg-content" viewBox="0 0 128 128" style="width: 1em; height: 1em;"><path d="m64 17.43a46.754 46.754 0 0 0 -27.4 84.638l.043.03.008.006a46.775 46.775 0 0 0 54.692 0l.046-.032a46.754 46.754 0 0 0 -27.389-84.642zm-24.62 82.305v-3.025a22.766 22.766 0 0 1 22.77-22.78h1.735.115s.076 0 .115 0h1.735a22.766 22.766 0 0 1 22.77 22.78v3.025a43.233 43.233 0 0 1 -49.24 0zm24.735-29.3h-.23a15.518 15.518 0 0 1 -15.454-15.5c0-.4.017-.806.051-1.214a15.571 15.571 0 0 1 31.037.012c.033.4.05.8.05 1.2a15.518 15.518 0 0 1 -15.454 15.5zm28.005 26.586v-.311a26.261 26.261 0 0 0 -18.82-25.199 18.966 18.966 0 0 0 9.766-16.58c0-.5-.021-1-.062-1.484a19.07 19.07 0 0 0 -38.013-.012c-.042.491-.063.994-.063 1.5a18.959 18.959 0 0 0 9.772 16.576 26.26 26.26 0 0 0 -18.82 25.199v.311a43.25 43.25 0 1 1 56.24 0z"></path></svg><img></span>
					  &nbsp;​&nbsp;login/join us
			     </a>
		     </c:when>
		 	<c:otherwise>
		 		${user_nickname}님 환영합니다.<br>
	     		<a class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-palette-1-dark-1 u-btn-1"
			         href="<c:url value='/user/logout' />"> 
					  <span class="u-icon u-icon-1"><svg class="u-svg-content" viewBox="0 0 128 128" style="width: 1em; height: 1em;"><path d="m64 17.43a46.754 46.754 0 0 0 -27.4 84.638l.043.03.008.006a46.775 46.775 0 0 0 54.692 0l.046-.032a46.754 46.754 0 0 0 -27.389-84.642zm-24.62 82.305v-3.025a22.766 22.766 0 0 1 22.77-22.78h1.735.115s.076 0 .115 0h1.735a22.766 22.766 0 0 1 22.77 22.78v3.025a43.233 43.233 0 0 1 -49.24 0zm24.735-29.3h-.23a15.518 15.518 0 0 1 -15.454-15.5c0-.4.017-.806.051-1.214a15.571 15.571 0 0 1 31.037.012c.033.4.05.8.05 1.2a15.518 15.518 0 0 1 -15.454 15.5zm28.005 26.586v-.311a26.261 26.261 0 0 0 -18.82-25.199 18.966 18.966 0 0 0 9.766-16.58c0-.5-.021-1-.062-1.484a19.07 19.07 0 0 0 -38.013-.012c-.042.491-.063.994-.063 1.5a18.959 18.959 0 0 0 9.772 16.576 26.26 26.26 0 0 0 -18.82 25.199v.311a43.25 43.25 0 1 1 56.24 0z"></path></svg><img></span>
					  &nbsp;​&nbsp;logout
			     </a>
			</c:otherwise>  
		</c:choose>	 
        </p>
      </div></header>
    <section class="u-clearfix u-white u-section-1" id="sec-f441">
      <div class="u-clearfix u-sheet u-sheet-1">
        <div class="u-container-style u-group u-opacity u-opacity-95 u-palette-1-light-3 u-shape-rectangle u-group-1">
          <div class="u-container-layout u-container-layout-1">
            <h3 class="u-text u-text-default u-text-1" style="font-family: 'Gugi', sans-serif;">드라이브 코스 추천</h3>
            <h4 class="u-text u-text-default u-text-2" style="font-family: 'Gugi', sans-serif;">dbdeep</h4>
            <div class="u-expanded-width u-list u-list-1">
              <div class="u-repeater u-repeater-1">
                <div class="u-container-style u-effect-hover-zoom u-image-round u-list-item u-radius-7 u-repeater-item u-shading u-list-item-1" data-image-width="150" data-image-height="99" 
                data-href="<c:url value='/course' />">
                  <div class="u-background-effect u-expanded">
                    <div class="u-background-effect-image u-expanded u-image u-image-1" data-image-width="150" data-image-height="99" data-href="//드라이브코스추천링크"></div>
                  </div>
                  <div class="u-container-layout u-similar-container u-container-layout-2">
                    <h4 class="u-align-center u-text u-text-3" style="font-family: 'Do Hyeon', sans-serif;">드라이브<br>코스 추천
                    </h4>
                    <p class="u-text u-text-4" style="font-family: 'Do Hyeon', sans-serif;">지역과 테마,&nbsp; 소요시간 별 드라이브 코스를 찾아보세요!</p>
                  </div>
                </div>
                <div class="u-container-style u-effect-hover-zoom u-image-round u-list-item u-radius-7 u-repeater-item u-shading u-list-item-2" data-image-width="1280" data-image-height="853" 
                data-href="<c:url value='/course/course_rank' />">
                  <div class="u-background-effect u-expanded">
                    <div class="u-background-effect-image u-expanded u-image u-shading u-image-2" data-image-width="1280" data-image-height="853" data-href="//베스트드라이브코스"></div>
                  </div>
                  <div class="u-container-layout u-similar-container u-container-layout-3">
                    <h4 class="u-align-center u-text u-text-5" style="font-family: 'Do Hyeon', sans-serif;">베스트 드라이브 코스 순위</h4>
                    <p class="u-text u-text-6" style="font-family: 'Do Hyeon', sans-serif;">가장 인기 많은 드라이브 코스를 한눈에</p>
                  </div>
                </div>
                <c:choose>
				        <c:when test="${user_id eq 0}">
					       <div class="u-container-style u-effect-hover-zoom u-image-round u-list-item u-radius-7 u-repeater-item u-shading u-list-item-3" data-image-width="1280" data-image-height="852" data-href="<c:url value='/user/login/form' />">
			                  <div class="u-background-effect u-expanded">
			                    <div class="u-background-effect-image u-expanded u-image u-shading u-image-3" data-image-width="1280" data-image-height="852" ></div>
			                  </div>
			                  <div class="u-container-layout u-similar-container u-container-layout-4">
			                    <h4 class="u-align-center u-text u-text-7" style="font-family: 'Do Hyeon', sans-serif;">드라이브 코스<br>입력
			                    </h4>
			                    <p class="u-text u-text-8" style="font-family: 'Do Hyeon', sans-serif;">나만의 드라이브 코스를 공유하고 직접 입력해볼 수 있는 기회!</p>
			                  </div>
			                </div>
					     </c:when>
					 	<c:otherwise>
				     		<div class="u-container-style u-effect-hover-zoom u-image-round u-list-item u-radius-7 u-repeater-item u-shading u-list-item-3" data-image-width="1280" data-image-height="852" data-href="<c:url value='/course/form' />">
			                  <div class="u-background-effect u-expanded">
			                    <div class="u-background-effect-image u-expanded u-image u-shading u-image-3" data-image-width="1280" data-image-height="852" ></div>
			                  </div>
			                  <div class="u-container-layout u-similar-container u-container-layout-4">
			                    <h4 class="u-align-center u-text u-text-7" style="font-family: 'Do Hyeon', sans-serif;">드라이브 코스<br>입력
			                    </h4>
			                    <p class="u-text u-text-8" style="font-family: 'Do Hyeon', sans-serif;">나만의 드라이브 코스를 공유하고 직접 입력해볼 수 있는 기회!</p>
			                  </div>
			                </div>
						</c:otherwise>  
					</c:choose>	  
                <div class="u-container-style u-effect-hover-zoom u-image-round u-list-item u-radius-7 u-repeater-item u-shading u-list-item-4" data-image-width="1280" data-image-height="690" data-href="음악추천 링크">
                  <div class="u-background-effect u-expanded">
                    <div class="u-background-effect-image u-expanded u-image u-shading u-image-4" data-image-width="1280" data-image-height="690" data-href="음악추천 링크"></div>
                  </div>
                  <div class="u-container-layout u-similar-container u-container-layout-5">
                    <h4 class="u-align-center u-text u-text-9" style="font-family: 'Do Hyeon', sans-serif;">드라이브 플레이리스트 추천</h4>
                    <p class="u-text u-text-10" style="font-family: 'Do Hyeon', sans-serif;">드라이브 코스에 맞는 플레이리스트를 지금 당장 들어보세요</p>
                  </div>
                </div>
                <div class="u-container-style u-effect-hover-zoom u-image-round u-list-item u-radius-7 u-repeater-item u-shading u-list-item-5" data-image-width="1280" data-image-height="853" data-href="//핫플링크">
                  <div class="u-background-effect u-expanded">
                    <div class="u-background-effect-image u-expanded u-image u-shading u-image-5" data-image-width="1280" data-image-height="853" data-href="//핫플링크"></div>
                  </div>
                  <div class="u-container-layout u-similar-container u-container-layout-6">
                    <h4 class="u-align-center u-text u-text-11" style="font-family: 'Do Hyeon', sans-serif;">드라이브 코스 주변 핫플&nbsp;<br>알아보기
                    </h4>
                    <p class="u-text u-text-12" style="font-family: 'Do Hyeon', sans-serif;">드라이브 코스 주변의 맛집과 카페를 같이!</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-palette-1-light-3 u-footer" id="sec-9f7d"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1" style="font-family: 'Gugi', sans-serif;">dpdeep</p>
      </div></footer>
  </body>
</html>