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
    	List<Course> courseList = new ArrayList<Course>();
    	int id = -1;
    	try {
    		id = UserSessionUtils.getLoginUserId(session);
    	} catch (Exception e) {
    		courseList = manager.allCourseList();
    		request.setAttribute("courseList", courseList);	
    		request.setAttribute("controller", "List");
    		return "/course/course_matching.jsp"; //�α��� ���� �ʾ��� ��
    	}

    	System.out.println("user id : " + id);
    	
    	List<Region>regionList = manager2.regionList(id);
    	List<Theme>themeList = manager2.themeList(id);
    	
    	List<Course> courseList1;
    	List<Course> courseList2;

    	if(regionList.size() == 0 || themeList.size() == 0) { //�α����� ������ ��ȣŰ���带 �������� ���� ���
    		courseList = manager.allCourseList(); 
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
    		
    		courseList1 = manager.keywordCourseList(regionString, themeString);
    		courseList2 = manager.notKeywordCourseList(regionString, themeString);
    		
    		courseList.addAll(courseList1);
    		courseList.addAll(courseList2);
    	}
		
		
		
		// courseList ��ü�� request�� �����Ͽ� �ڽ� ����Ʈ ȭ������ �̵�(forwarding)
		request.setAttribute("courseList", courseList);	
		request.setAttribute("controller", "List");		
		return "/course/course_matching.jsp"; 
    }
}
