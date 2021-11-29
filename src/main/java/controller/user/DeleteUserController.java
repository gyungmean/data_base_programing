package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;
import model.service.UserManager;

public class DeleteUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(DeleteUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int deleteId = Integer.parseInt(request.getParameter("user_id"));
    	log.debug("Delete User : {}", deleteId);

    	UserManager manager = UserManager.getInstance();		
		HttpSession session = request.getSession();	
	
		if (UserSessionUtils.isLoginUser(deleteId, session)) { // 로그인한 사용자가 삭제 대상인 경우 (자기 자신을 삭제)	
			manager.remove(deleteId);				// 사용자 정보 삭제
		}
		return "main.jsp";	// logout 처리
	}
}
