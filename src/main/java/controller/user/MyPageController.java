package controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Comment;
import model.Course;
import model.Region;
import model.Theme;
import model.User;
import model.service.CourseManager;
import model.service.Course_likeManager;
import model.service.UserManager;
import repository.mybatis.CommentMapperRepository;

public class MyPageController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(MyPageController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	try {
    		log.debug("MyPageController start");
			HttpSession session = request.getSession();
	    	int userId = UserSessionUtils.getLoginUserId(session);
	    	System.out.println("controller userId : " + userId);
	    	
	    	UserManager usermanager = UserManager.getInstance();
	    	User user = usermanager.findUser(userId);
	    	
	    	//ȸ������
	    	String userNickname = user.getNickname();
	    	String email = user.getEmail();
	    	
	    	if (request.getMethod().equals("POST")) {	
	    		log.debug("POST �������� �޾��� / " + userId + "�� �г��� ����");
	    		String newNickname = request.getParameter("nickname");
	    		int result = usermanager.updateNickName(userId, newNickname);
	    		log.debug("nick name update! : " + result);
	    		if(result == 0) {
	    			log.debug("update faile");
	    			return "/user/user_info.jsp";
	    		}
				return "/user/user_info.jsp";   // �˻��� ����� ������ update form���� ����     	
		    }
			request.setAttribute("userId", userId);
			request.setAttribute("userNickname", userNickname);
			request.setAttribute("email", email);
			
			//��ȣŰ����
			List<Region> regionList = new ArrayList<>();
			List<Theme> themeList = new ArrayList<>();
			
			regionList = usermanager.regionList(userId);
			themeList = usermanager.themeList(userId);
			
			request.setAttribute("regionList", regionList);
			request.setAttribute("themeList", themeList);
			
			//���ƿ� �� �ڽ�
			Course_likeManager courseListManager = Course_likeManager.getInstance();
			List<Course> likeCourseList = courseListManager.user_likeCourseList(userId);
			
			request.setAttribute("likeCourseList", likeCourseList);
			
			//���� �ۼ��ѱ�
			CourseManager courseManager = CourseManager.getInstance();
			List<Course> writeCourseList = courseManager.findCourseByUserId(userId);
		
			request.setAttribute("writeCourseList", writeCourseList);
			log.debug("writeCourseList success");
			
			CommentMapperRepository commentDao = new CommentMapperRepository();
			List<Comment> writeCommentsList = commentDao.selectCommentsByUserId(userId);
			
			request.setAttribute("writeCommentsList", writeCommentsList);
			
			return "/user/user_info.jsp";
		} catch(Exception e) {
			request.setAttribute("userId", 0);
			return "redirect:/main";
		}
		
    }
}
