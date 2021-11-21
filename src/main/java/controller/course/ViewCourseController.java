package controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CourseManager;
import model.Course;

public class ViewCourseController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
    	Course course = null;
		CourseManager manager = CourseManager.getInstance();
		int courseId = Integer.parseInt(request.getParameter("course_id"));
		course = manager.courseInfo(courseId);		// 코스 정보 검색			
		
		request.setAttribute("course", course);	// 코스 정보 저장				
		return "/course/course_detail.jsp";				// 코스 보기 화면으로 이동
    }
}
