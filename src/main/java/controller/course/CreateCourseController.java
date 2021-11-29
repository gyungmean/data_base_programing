package controller.course;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.course.CreateCourseController;
import controller.user.UserSessionUtils;
import model.Course;
import model.Theme;
import model.service.CourseManager;

public class CreateCourseController implements Controller {

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    
	    	HttpSession session = request.getSession();
	    	int id = UserSessionUtils.getLoginUserId(session);
 	
	     	
	    	int parking = 0;
	    	if (request.getParameter("parking") != null) {
	    		parking = 1;
	    	}

	    	int region_id = Integer.parseInt(request.getParameter("region_id"));
	    	
	    	
	    	List<Integer> themeIdList = new ArrayList<Integer>();
	    	List<String> themeStringList = new ArrayList<String>();
	    	for(String s : request.getParameterValues("themeIdList")) {
	    		themeIdList.add(Integer.parseInt(s));
	    	}
	    	
	    	for(String s : request.getParameterValues("themeIdList")) {
	    		themeStringList.add(s);
	    	}
	    	
	    	List<Theme> themeList = new ArrayList<Theme>();
	    	
	    	Course course = new Course(
	    		0, request.getParameter("course_name"),
				request.getParameter("departure"), request.getParameter("stopover"),
				request.getParameter("destination"), request.getParameter("time"),
				parking, region_id, themeList, id);		
	        
			CourseManager manager = CourseManager.getInstance();
			int course_id = manager.create(course, themeIdList);
			String regionName = manager.regionName(region_id);
			List<String> themeName = manager.themeName(themeStringList);

			request.setAttribute("course", course);
			request.setAttribute("region", regionName);
			request.setAttribute("themeList", themeName);
			request.setAttribute("controller", "Create");
			request.setAttribute("course_id", course_id);
			
			return "/course/course_detail";
			
		
	    }
}