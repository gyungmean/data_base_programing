package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.UserManager;

public class KeywordUserController implements Controller {
	//선호키워드 선택 후
	//DAO에 함수 2개만들어서 연결
	  public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		System.out.println("keywordUserController 도착");
		
		String[] theme = request.getParameterValues("themeIdList");
		String[] region = request.getParameterValues("region_id");
		
		System.out.print("theme : ");
		for(String item : theme) {
			System.out.print(item);
		}
		System.out.print("\nregion : ");
		for(String item : region) {
			System.out.println(item);
		}
		
		if(theme == null && region == null) {
			System.out.println("theme, region 둘다 null 이다");
			return "redirect:/main";
		}
		
		try {
			UserManager manager = UserManager.getInstance();
//			HttpSession session = request.getSession();
//			int user_id = UserSessionUtils.getLoginUserId(session);
			
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			
			System.out.println("userid : " + user_id);
			
			for(String item : theme) {
				manager.createTheme(user_id, Integer.parseInt(item));
			}
			for(String item : region) {
				manager.createRegion(user_id, Integer.parseInt(item));
			}
			 return "redirect:/main";
			
		} catch(Exception e) {
			return "/user/login_register.jsp";	
	    }
	  }
}
