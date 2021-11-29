package controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.CourseManager;
import model.service.Course_likeManager;
import model.service.ExistingUserException;
import model.Course;
import model.User;

public class ViewCourseController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
    	if(request.getMethod().equals("POST")) {
    		System.out.println("viewCourseController�� post������� ����");		
    		try {
    			Course_likeManager manager3 = Course_likeManager.getInstance();
    			
    			int courseId = Integer.parseInt(request.getParameter("course_id"));
    			HttpSession session = request.getSession();
    	    	int userId = UserSessionUtils.getLoginUserId(session);
    	    	
    			manager3.createLike(userId, courseId);
    	        return "redirect:/course";	//redirection ���� ���� detail�� �ϸ� �ٽ� �ڽ� ���̵� �޾ƿ��� �������� ������ ���� 
    	        
    		} catch (ExistingUserException e) {	
    			request.setAttribute("exception", e);
    			System.out.println("���ƿ� ������ ���� �߻�");
    			return "main.jsp";
    		}
    	}
    	else {
    	Course course = new Course();
    	User user = new User();
		CourseManager manager = CourseManager.getInstance();
		Course_likeManager manager2 = Course_likeManager.getInstance();
		
		int courseId = Integer.parseInt(request.getParameter("course_id"));
		course = manager.courseInfo(courseId);		// �ڽ� ���� �˻�		
		int regionId = course.getRegion_id();
		int like_count = manager2.countLike(courseId);
		String region_name = manager.regionName(regionId);
		
		request.setAttribute("user", user);	
		request.setAttribute("course", course);	// �ڽ� ���� ����		
		request.setAttribute("like_count", like_count);
		request.setAttribute("region_name", region_name);
		return "/course/course_detail.jsp";				// �ڽ� ���� ȭ������ �̵�
    	}
    }
}
