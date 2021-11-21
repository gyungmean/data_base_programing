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
		
		// courseList ��ü�� request�� �����Ͽ� �ڽ� ����Ʈ ȭ������ �̵�(forwarding)
		request.setAttribute("courseList", courseList);	
		request.setAttribute("controller", "List");		
		return "/course/course_matching.jsp"; 
    }
}
