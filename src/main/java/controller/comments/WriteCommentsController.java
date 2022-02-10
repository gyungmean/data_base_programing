package controller.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;

public class WriteCommentsController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
    	int id = UserSessionUtils.getLoginUserId(session);
    	
		return "/comments/comments_view.jsp";
	}

}
