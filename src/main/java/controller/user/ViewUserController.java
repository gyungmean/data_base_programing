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
    	// �α��� ���� Ȯ��
    	if (!UserSessionUtils.hasLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form ��û���� redirect
        }
    	
		UserManager manager = UserManager.getInstance();
		String email = request.getParameter("email");

    	User user = null;
    	try {
			user = manager.findUserId(email);	// ����� ���� �˻�
		} catch (UserNotFoundException e) {				
	        return "redirect:/user/list";
		}	
		
    	request.setAttribute("user", user);		// ����� ���� ����	
    	int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		List<Region> regionList = manager.regionList(user_id);
		List<Theme> themeList = manager.themeList(user_id);
		// List<User> userList = manager.findUserList(currentPage, countPerPage);

		// userList ��ü�� ���� �α����� ����� ID�� request�� �����Ͽ� ����
		request.setAttribute("regionList", regionList);			
		request.setAttribute("themeList", themeList);		
		request.setAttribute("curUserId", 
				UserSessionUtils.getLoginUserId(request.getSession()));		

		
		return "main.jsp";				// ����� ���� ȭ������ �̵�
    }
}
