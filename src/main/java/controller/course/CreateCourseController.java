package controller.course;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

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
	    	
	    	request.setCharacterEncoding("UTF-8");
	    	String path = request.getSession().getServletContext().getRealPath("/uploaded");
	    	System.out.println(path);

	        int size = 1024 * 1024 * 20; //20MB
	        String str, filename = null, original_filename;
	        MultipartRequest multiRequest = new MultipartRequest(request, path, size, "UTF-8", new DefaultFileRenamePolicy());
        	
	        try{
	        	
	        	Enumeration files = multiRequest.getFileNames();
	        	str = (String)files.nextElement();
	        	filename = multiRequest.getFilesystemName(str);
	        	original_filename = multiRequest.getOriginalFileName(str);
	        	
	        	System.out.println("str : "+str);
	        	System.out.println("filename : "+filename);
	        	System.out.println("original_filename : "+original_filename);
	        } catch (Exception e){
	        	e.printStackTrace();

	        }
	        
	        
		    	HttpSession session = request.getSession();
		    	int id = UserSessionUtils.getLoginUserId(session);
		    	CourseManager manager = CourseManager.getInstance();
		    	
		    	String course_name;
		    	try {
		    		course_name = multiRequest.getParameter("course_name");
		    		manager.exist(course_name);
		    	}
		    	 catch (ExistingCourseException e) {	// 예외 발생 시 회원가입 form으로 forwarding
		             request.setAttribute("registerFailed", true);
		 			request.setAttribute("exception", e);
		 			System.out.println("코스생성 시 예외 발생");
	    			return "/course/course_create.jsp";
	    		}
		    	
		    	int parking = 0;
		    	if (multiRequest.getParameter("parking") != null) {
		    		parking = 1;
		    	}

		    	int region_id = Integer.parseInt(multiRequest.getParameter("region_id"));
		    	
		    	
		    	List<Integer> themeIdList = new ArrayList<Integer>();
		    	List<String> themeStringList = new ArrayList<String>();
		    	for(String s : multiRequest.getParameterValues("themeIdList")) {
		    		themeIdList.add(Integer.parseInt(s));
		    	}
		    	
		    	for(String s : multiRequest.getParameterValues("themeIdList")) {
		    		themeStringList.add(s);
		    	}
		    	
		    	List<Theme> themeList = new ArrayList<Theme>();
		    	
		    	 
		    	Course course = new Course(
		    		0, course_name,
		    		multiRequest.getParameter("departure"), multiRequest.getParameter("stopover"),
		    		multiRequest.getParameter("destination"), multiRequest.getParameter("time"),
					parking, region_id, themeList, id, filename );		
		    		
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