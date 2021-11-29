package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.service.UserManager;
import model.User;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: ȸ������ ���� form ��û	
    		// ������ UpdateUserFormController�� ó���ϴ� �۾��� ���⼭ ����
    		int updateId = Integer.parseInt(request.getParameter("user_id"));

    		log.debug("UpdateForm Request : {}", updateId);
    		
    		UserManager manager = UserManager.getInstance();
			User user = manager.findUser(updateId);	// �����Ϸ��� ����� ���� �˻�
			request.setAttribute("user", user);			

			HttpSession session = request.getSession();
			if (UserSessionUtils.isLoginUser(updateId , session)) 
//				UserSessionUtils.isLoginUser("admin", session))
				{
				// ���� �α����� ����ڰ� ���� ��� ������̰ų� �������� ��� -> ���� ����
				return "/user/login_register.jsp";   // �˻��� ����� ������ update form���� ����     
				}
			    
			
			// else (���� �Ұ����� ���) ����� ���� ȭ������ ���� �޼����� ����
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("Ÿ���� ������ ������ �� �����ϴ�."));            
			return "main.jsp";	// ����� ���� ȭ������ �̵� (forwarding) ������������ ������
	    }	
    	
    	// POST request (ȸ�������� parameter�� ���۵�)
    	int user_id = Integer.parseInt(request.getParameter("user_id"));
    	User updateUser = new User(
			user_id,
    		request.getParameter("password"),
    		request.getParameter("nickname"),
    		request.getParameter("email")
    	);

    	log.debug("Update User : {}", updateUser);

		UserManager manager = UserManager.getInstance();
		manager.update(updateUser);			
		return "main.jsp";	// ����� ���� ȭ������ �̵� (forwarding)	 ������������ ������
    }
}
