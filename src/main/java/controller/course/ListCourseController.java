package controller.course;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Course;
import model.service.CourseManager;

public class ListCourseController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	CourseManager manager = CourseManager.getInstance();
		List<Course> courseList = manager.allCourseList();
		
		// courseList 객체를 request에 저장하여 코스 리스트 화면으로 이동(forwarding)
		request.setAttribute("courseList", courseList);	
		request.setAttribute("controller", "List");		
		return "/course/course_matching.jsp"; 
    }
}
