package controller.comments;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Course;
import model.User;
import model.service.CourseManager;
import model.service.Course_likeManager;

public class MoveCommentsController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MoveCommentsController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("moveCommentsController도착");
		
		Course course = new Course();
    	User user = new User();
		CourseManager manager = CourseManager.getInstance();
		Course_likeManager manager2 = Course_likeManager.getInstance();
		
		int courseId = Integer.parseInt(request.getParameter("course_id"));
		log.debug("courseId" + courseId);
		
		course = manager.courseInfo(courseId);		// 코스 정보 검색		
		int regionId = course.getRegion_id();
		int like_count = manager2.countLike(courseId);
		String region_name = manager.regionName(regionId);
		
		request.setAttribute("user", user);	
		request.setAttribute("course", course);	// 코스 정보 저장		
		request.setAttribute("like_count", like_count);
		request.setAttribute("region_name", region_name);
		
		return "/course/course_detail.jsp";				// 코스 보기 화면으로 이동
	}

}
