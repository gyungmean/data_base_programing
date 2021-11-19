<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="page_type" content="np-template-header-footer-from-plugin">
    <title>login</title>
    <link rel="stylesheet" href="<c:url value='/user_login/nicepage.css' />" media="screen">
<link rel="stylesheet" href="<c:url value='/user_login/mainpage.css' />" media="screen">
	
    <script class="u-script" type="text/javascript" src="<c:url value='/user_login/jquery.js' />" defer=""></script>
    <script class="u-script" type="text/javascript" src="<c:url value='/user_login/nicepage.js' />" defer=""></script>
    <meta name="generator" content="Nicepage 3.29.1, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": ""
	}
	</script>
	<script>
	login = function() {
		if (form.email.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
	}
	</script>
	<script>
	userCreate(targetUri) = function() {
		form2.action = targetUri;
		form2.method="GET";		// register form 요청
		alert(form2.method)
		form2.submit();
	}
	</script>
	
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="mainpage">
    <meta property="og:type" content="website">
  </head>
  
  <body class="u-body">
  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.js"></script>
  <header class="u-clearfix u-header u-header" id="sec-5a17"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-text u-text-1">
          <a class="u-active-none u-border-none u-btn u-button-link u-button-style u-hover-none u-none u-text-palette-1-dark-1 u-btn-1" href="https:/loginform"><span class="u-icon u-icon-1"><svg class="u-svg-content" viewBox="0 0 128 128" style="width: 1em; height: 1em;"><path d="m64 17.43a46.754 46.754 0 0 0 -27.4 84.638l.043.03.008.006a46.775 46.775 0 0 0 54.692 0l.046-.032a46.754 46.754 0 0 0 -27.389-84.642zm-24.62 82.305v-3.025a22.766 22.766 0 0 1 22.77-22.78h1.735.115s.076 0 .115 0h1.735a22.766 22.766 0 0 1 22.77 22.78v3.025a43.233 43.233 0 0 1 -49.24 0zm24.735-29.3h-.23a15.518 15.518 0 0 1 -15.454-15.5c0-.4.017-.806.051-1.214a15.571 15.571 0 0 1 31.037.012c.033.4.05.8.05 1.2a15.518 15.518 0 0 1 -15.454 15.5zm28.005 26.586v-.311a26.261 26.261 0 0 0 -18.82-25.199 18.966 18.966 0 0 0 9.766-16.58c0-.5-.021-1-.062-1.484a19.07 19.07 0 0 0 -38.013-.012c-.042.491-.063.994-.063 1.5a18.959 18.959 0 0 0 9.772 16.576 26.26 26.26 0 0 0 -18.82 25.199v.311a43.25 43.25 0 1 1 56.24 0z"></path></svg><img></span>&nbsp;​&nbsp;login / join us
          </a>
        </p>
      </div></header> 
    <section class="u-align-center u-clearfix u-grey-5 u-section-1" id="sec-8679">
      <div class="u-clearfix u-sheet u-valign-middle u-sheet-1">
        <div class="u-clearfix u-expanded-width u-layout-wrap u-layout-wrap-1">
          <div class="u-layout">
            <div class="u-layout-row">
              <div class="u-align-left u-container-style u-image u-layout-cell u-size-31 u-image-1" data-image-width="2000" data-image-height="1333">
                <div class="u-container-layout u-container-layout-1"></div>
              </div>
              <div class="u-align-center-sm u-align-center-xs u-container-style u-layout-cell u-shape-rectangle u-size-29 u-white u-layout-cell-2">
                <div class="u-container-layout u-valign-middle u-container-layout-2">
                  <h3 class="u-align-center-lg u-align-center-md u-align-center-xl u-text u-text-default u-text-1">Welcome</h3>
                  <div class="u-image u-image-circle u-image-2" data-image-width="2000" data-image-height="1333"></div>
                  <div class="u-expanded-width-xs u-form u-login-control u-form-1">
                    <form action="<c:url value='/user/login' />"
 method="POST" class="u-clearfix u-form-custom-backend u-form-spacing-15 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 0px;">
                      <div class="u-form-group u-form-name">
                        <label for="username-5b0a" class="u-form-control-hidden u-label"></label>
                        <input type="text" placeholder="Enter your email adress" id="username-5b0a" name="email" class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle" required="">
                      </div>
                      <div class="u-form-group u-form-password">
                        <label for="password-5b0a" class="u-form-control-hidden u-label"></label>
                        <input type="text" placeholder="Enter your Password" id="password-5b0a" name="password" class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-input u-input-rectangle" required="">
                      </div>
                      <div class="u-align-center u-form-group u-form-submit">
                        <input type = "button" value = "login" class="u-active-palette-1-light-1 u-border-none u-btn u-btn-round u-btn-submit u-button-style u-hover-palette-1-light-1 u-palette-1-base u-radius-50 u-text-body-alt-color u-btn-1"
                        onClick="login()">
                        <input type="submit" value="submit" class="u-form-control-hidden">
                      </div>
                      <input type="hidden" value="" name="recaptchaResponse">
                    </form>
                  </div>
                  <form name = "form2" action = "<c:url value='/user/register'/>" >
                  <input type = "button" value = "계정이 없으신가요?&nbsp; 지금 회원가입 하세요!" class="u-border-1 u-border-active-palette-1-base u-border-hover-palette-1-base u-btn u-button-style u-login-control u-login-forgot-password u-none u-text-palette-1-base u-btn-2"
                  onClick="userCreate('<c:url value='/user/register'/>')" >
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-palette-1-light-3 u-footer" id="sec-9f7d"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">dpdeep</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/website-templates" target="_blank">
        <span>Website Templates</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="" target="_blank">
        <span>Website Builder Software</span>
      </a>. 
    </section>
  </body>
</html>