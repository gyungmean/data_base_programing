package controller.course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.CourseManager;
import model.Course;

public class MatchCourseController implements Controller{
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	CourseManager manager = CourseManager.getInstance();
    	
    	int region_id = Integer.parseInt(request.getParameter("region_id"));
    	String time = request.getParameter("time");
    	List<String> themeIdList = new ArrayList<String>();
    	
    	for(String s : request.getParameterValues("themeIdList")) {
    		themeIdList.add(s);
    	}
    	
		List<Course> courseList = manager.matchCourse(time, region_id, themeIdList);
		
		// courseList 객체를 request에 저장하여 코스 리스트 화면으로 이동(forwarding)
		request.setAttribute("courseList", courseList);				
		return "/course/matching.jsp";  //경로 수정 필요  
    }
}