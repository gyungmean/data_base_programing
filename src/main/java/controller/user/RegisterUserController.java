package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 등록 form 요청	
    		log.debug("RegisterForm Request");
    		System.out.println("get 형식으로 받았음");
			return "/user/login_register.jsp";   // 검색한 사용자 정보를 update form으로 전송     	
	    }	

    	// POST request (회원정보가 parameter로 전송됨)
       	System.out.println("post 형식으로 받았음");
       	
//       email 합치기
       	String front_email = request.getParameter("front_email");
       	String domain = request.getParameter("domain");
       	String e_domain = request.getParameter("e_domain");
       	String email;
       	if(domain.equals("0"))
       		email = front_email + "@" + e_domain;
       	else
       		email = front_email + "@" + domain;
       	
//       	int user_id = Integer.parseInt(request.getParameter("user_id"));
		 User user = new User(
			0,
			request.getParameter("password"),
			request.getParameter("nickname"),
			email);
		
        log.debug("Create User : {}", user);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
	        return "redirect:/main";	// 성공 시 사용자 리스트 화면으로 redirect
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			System.out.println("회원가입 시 예외 발생");
			return "/user/login_register.jsp";
		}
    }
}
