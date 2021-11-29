package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.user.UserSessionUtils;

public class MainController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("mainController·Î ³Ñ¾î¿È");
		
		try {
			HttpSession session = request.getSession();
	    	int userId = UserSessionUtils.getLoginUserId(session);
	    	System.out.println("controller userId : " + userId);
			request.setAttribute("userId", userId);
			return "/main.jsp";
		} catch(Exception e) {
			request.setAttribute("userId", 0);
			return "/main.jsp";
		}
	}

}
