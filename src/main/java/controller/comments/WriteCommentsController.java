package controller.comments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Comment;
import model.Course;
import model.service.CourseManager;
import repository.mybatis.CommentMapperRepository;

public class WriteCommentsController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(WriteCommentsController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("WriteCommentsController start");
		if (request.getMethod().equals("GET")) {	
    		log.debug("get 형식으로 받았음");
    		String search_word = request.getParameter("search_word");
    		CourseManager manager = CourseManager.getInstance();
    		List<Course> courseList = manager.findCourse(search_word);
    		request.setAttribute("courseList", courseList);
			return "/comments/comments_write.jsp";   // 검색한 사용자 정보를 update form으로 전송     	
	    }	
		
		log.debug("post 형식으로 받았음");
		HttpSession session = request.getSession();
		
    	int userId = UserSessionUtils.getLoginUserId(session);
    	
    	SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        
    	CommentMapperRepository commentDao = new CommentMapperRepository();
    	Comment comment = new Comment();
    	
    	try {
    		String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		int courseId = Integer.valueOf(request.getParameter("courseId"));
    		log.debug("Comment : "
    				+ "\n userId: " + userId
    				+ "\n title: " + title
    				+ "\n content: " + content
    				+ "\n Regdate: " + date
    				+ "\n courseId: " + courseId);
    		
    		comment.setTitle(title);
    		comment.setCommentContent(content);
    		comment.setRegDate(date);
    		comment.setUserId(userId);
    		comment.setCourseId(courseId);
    		
    	} catch (Exception e) {
    		log.error("WriteCommentsController error");
    		return "/comments/comments_write.jsp";
    	}
    	
    	commentDao.insertComment(comment);

		return "redirect:/comments";
	}

}
