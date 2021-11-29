<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Join</title>
	 <link rel="stylesheet" href="<c:url value='/user_login_register/style.css' />">
</head>
<body>
	<script>
 		domainCheck = function() { 
  			var frm=document.register;

   			if(frm.domain.value==0){  //직접입력 선택시
   				frm.e_domain.value="";
   				frm.e_domain.disabled=false;
  			}
   			else{
   				frm.e_domain.value=frm.domain.value; //text에 이메일 주소 들어감
   				frm.e_domain.disabled=true; //비활성화
  			}
 		}
 		
 		userCreate = function() {
 			register.method="POST";
 			register.submit();
 		}
 	</script>
	<div class="wrap">
		<div class="form-wrap">
			<div class="title">Register</div>
                <form name="register" id="register" action="<c:url value='/user/register' />" class="input-group">
					<input type="text" class="input-email" name="front_email" placeholder="Your Email" required>
					@ <input name="e_domain" class="input-email" type="text" required>
					<select name="domain" onchange="domainCheck();">
						<option value = "0" selected="selected">직접입력</option>
    					<option value ="naver.com" >naver.com</option>
    					<option value ="gmail.com">gmail.com</option>
    					<option value ="hanmail.net">hanmail.net</option>
    					<option value ="nate.com">nate.com</option>
    					<option value ="hotmail.com">hotmail.com</option>
					</select>
					<button class="check-email" onClick="userCreate()" >중복확인</button>
					<input type="text" class="input-field" name="nickname" placeholder="Your nickname" required>
                    <input type="password" class="input-field" name="password" placeholder="Enter Password" required>
					<br><br>
                    <input type = "button" class="submit" onClick="userCreate()" value = "JOIN">
                </form>
                <c:if test="${registerFailed}">
	     			 <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    		</c:if>
		</div>
	</div>
</body>
</html>