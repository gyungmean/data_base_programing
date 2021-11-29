package controller.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Course;
import model.service.CourseManager;

public class FindCourseController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String search_word = request.getParameter("search_word");
		
		CourseManager manager = CourseManager.getInstance();
		
		List<Course> courseList = manager.findCourse(search_word);
		
		request.setAttribute("search_word", search_word);
		request.setAttribute("courseList", courseList);
		
		return "/course/course_search_result.jsp";
	}

}
