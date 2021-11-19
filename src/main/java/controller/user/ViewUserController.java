package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.UserManager;
import model.service.UserNotFoundException;
import model.Region;
import model.Theme;
import model.User;

public class ViewUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		String email = request.getParameter("email");

    	User user = null;
    	try {
			user = manager.findUserId(email);	// 사용자 정보 검색
		} catch (UserNotFoundException e) {				
	        return "redirect:/user/list";
		}	
		
    	request.setAttribute("user", user);		// 사용자 정보 저장	
    	int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		List<Region> regionList = manager.regionList(user_id);
		List<Theme> themeList = manager.themeList(user_id);
		// List<User> userList = manager.findUserList(currentPage, countPerPage);

		// userList 객체와 현재 로그인한 사용자 ID를 request에 저장하여 전달
		request.setAttribute("regionList", regionList);			
		request.setAttribute("themeList", themeList);		
		request.setAttribute("curUserId", 
				UserSessionUtils.getLoginUserId(request.getSession()));		

		
		return "main.jsp";				// 사용자 보기 화면으로 이동
    }
}
