package controller.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.comments.ListCommentsController;
import controller.user.UserSessionUtils;
import model.service.CommentManager;
import model.service.UserManager;
import repository.mybatis.CommentMapperRepository;

public class MoveCourseController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MoveCourseController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		log.debug("moveCourseControllerµµÂø");
		
		CommentManager manager = CommentManager.getInstance();
		
		int courseId = Integer.parseInt(request.getParameter("course_id"));
		
		List<model.Comment> commentsList = manager.selectCommentByCourseId(courseId);
		
		try {
			HttpSession session = request.getSession();
	    	int userId = UserSessionUtils.getLoginUserId(session);
	    	log.debug("userId: " + userId);
			request.setAttribute("userId", userId);
		} catch(Exception e) {
			request.setAttribute("userId", 0);
		}
		
		UserManager userManager = UserManager.getInstance();
		for(model.Comment c : commentsList) {
			c.setUser(userManager.getUserDAO().findUser(c.getUserId()));
		}
		
		request.setAttribute("commentsList", commentsList);
		
		return "/comments/comments_list.jsp";
	}

}
