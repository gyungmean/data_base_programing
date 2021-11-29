package controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.Course_likeManager;
import model.service.ExistingUserException;

public class LikeCourseController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		System.out.println("likeCourseController로 넘어옴");
		
		int courseId = Integer.parseInt(request.getParameter("course_id"));
		HttpSession session = request.getSession();
    	int userId = UserSessionUtils.getLoginUserId(session);
			
    	System.out.println("courseId " + courseId);
    	System.out.println("userId " + userId);
    	
		try {
			Course_likeManager manager = Course_likeManager.getInstance();
			manager.createLike(userId, courseId);
			return "redirect:/course";	
		} catch (ExistingUserException e) {	
			request.setAttribute("exception", e);
			System.out.println("좋아요 누를때 예외 발생");
			return "main.jsp";
		}
	}
}
