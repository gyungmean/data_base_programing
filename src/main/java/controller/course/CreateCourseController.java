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
import model.User;
import model.service.CourseManager;
import model.service.ExistingCourseException;
import model.service.ExistingUserException;

public class CreateCourseController implements Controller {

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	
	    
		    	HttpSession session = request.getSession();
		    	int id = UserSessionUtils.getLoginUserId(session);
		    	CourseManager manager = CourseManager.getInstance();
		    	
		    	String course_name;
		    	try {
		    		course_name = request.getParameter("course_name");
		    		manager.exist(course_name);
		    	}
		    	 catch (ExistingCourseException e) {	// 예외 발생 시 회원가입 form으로 forwarding
		             request.setAttribute("registerFailed", true);
		 			request.setAttribute("exception", e);
		 			System.out.println("코스생성 시 예외 발생");
	    			return "/course/course_create.jsp";
	    		}
		    	
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
		    		0, course_name,
					request.getParameter("departure"), request.getParameter("stopover"),
					request.getParameter("destination"), request.getParameter("time"),
					parking, region_id, themeList, id);		
		    		
					int course_id = manager.create(course, themeIdList);
					String regionName = manager.regionName(region_id);
					List<String> themeName = manager.themeName(themeStringList);
					
					User user = new User(id, null, null, null);

					request.setAttribute("course", course);
					request.setAttribute("region_name", regionName);
					request.setAttribute("themeList", themeName);
					request.setAttribute("controller", "Create");
					request.setAttribute("course_id", course_id);
					request.setAttribute("user", user);
					request.setAttribute("like_count", 0);
					
					return "/course/course_detail.jsp";
					
	    	
			
		
	    }
}