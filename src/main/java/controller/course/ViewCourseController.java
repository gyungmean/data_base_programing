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
		course = manager.courseInfo(courseId);		// �ڽ� ���� �˻�			
		
		request.setAttribute("course", course);	// �ڽ� ���� ����				
		return "/course/course_detail.jsp";				// �ڽ� ���� ȭ������ �̵�
    }
}
