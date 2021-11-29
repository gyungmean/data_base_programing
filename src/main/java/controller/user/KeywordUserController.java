package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.service.UserManager;

public class KeywordUserController {
	//선호키워드 선택 후
	//DAO에 함수 2개만들어서 연결
	  public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		  
		  UserManager manager = UserManager.getInstance();
	      
		HttpSession session = request.getSession();
		int user_id = UserSessionUtils.getLoginUserId(session);
			
			
//		String user_idS = request.getParameter("user_id");
//		int user_id = Integer.parseInt(user_idS);
		
		String[] theme = request.getParameterValues("theme_id");
		
		String[] region = request.getParameterValues("region_id");

		
		for(String item : theme) {
			manager.createTheme(user_id, Integer.parseInt(item));
		}
		for(String item : region) {
			manager.createRegion(user_id, Integer.parseInt(item));
		}
		
		
		
	        return "redirect:/main";			
	    }

	
}
