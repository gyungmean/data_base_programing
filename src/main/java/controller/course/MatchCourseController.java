package controller.course;

import java.util.ArrayList;
import java.util.LinkedHashSet;
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
    	
    	if (request.getMethod().equals("GET")) {	
    		// GET request: ȸ������ ��� form ��û	
    	
    		System.out.println("GET �������� �޾���");
	   }	
    	
    	int region_id = Integer.parseInt(request.getParameter("region_id"));
    	String time = request.getParameter("time");
    	List<Integer> themeIdList = new ArrayList<Integer>();
    	List<String> themeStringList = new ArrayList<String>();
    	for(String s : request.getParameterValues("themeIdList")) {
    		themeIdList.add(Integer.parseInt(s));
    	}
    	
    	for(String s : request.getParameterValues("themeIdList")) {
    		themeStringList.add(s);
    	}
    	
    	LinkedHashSet<Integer> courseIdList = manager.matchCourse(time, region_id, themeIdList);
    	List<Course> courseList = new ArrayList<Course>();
    	for(int i : courseIdList) {
			courseList.add(manager.courseInfo(i));
		}
		String regionName = manager.regionName(region_id);
		List<String> themeName = manager.themeName(themeStringList);
	
		
		// courseList ��ü�� request�� �����Ͽ� �ڽ� ����Ʈ ȭ������ �̵�(forwarding)
		request.setAttribute("courseList", courseList);
		request.setAttribute("region", regionName);
		request.setAttribute("themeList", themeName);
		request.setAttribute("controller", "Match");
		return "/course/course_matching.jsp"; 
    }
}