package controller.course;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Course;
import model.Region;
import model.Theme;
import model.service.CourseManager;
import model.service.UserManager;

public class ListCourseController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
    	CourseManager manager = CourseManager.getInstance();
    	UserManager manager2 = UserManager.getInstance();
    	
    	HttpSession session = request.getSession();
    	int id = UserSessionUtils.getLoginUserId(session); //�����ؾߵ�
    	
    	List<Region>regionList = manager2.regionList(id);
    	List<Theme>themeList = manager2.themeList(id);
    	
    	List<Course> courseList;
    	List<Course> courseList2;
    	
    	List<Course> resultList = new ArrayList<Course>();
    	if(regionList.size() == 0 || themeList.size() == 0) {
    		resultList = manager.allCourseList();
    	}
    	else {
    		List<String> regionString = new ArrayList<String>();
    		for(Region r : regionList) {
    			regionString.add(Integer.toString(r.getRegion_id()));
    		}
    		List<String> themeString = new ArrayList<String>();
    		for(Theme t : themeList) {
    			themeString.add(Integer.toString(t.getTheme_id()));
    		}
    		
    		courseList = manager.keywordCourseList(regionString, themeString);
    		courseList2 = manager.notKeywordCourseList(regionString, themeString);
    		
    		resultList.addAll(courseList);
    		resultList.addAll(courseList2);
    	}
		
		
		
		// courseList ��ü�� request�� �����Ͽ� �ڽ� ����Ʈ ȭ������ �̵�(forwarding)
		request.setAttribute("courseList", resultList);	
		request.setAttribute("controller", "List");		
		return "/course/course_matching.jsp"; 
    }
}
