package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       	if (request.getMethod().equals("GET")) {	
    		// GET request: ȸ������ ��� form ��û	
    		log.debug("RegisterForm Request");
    		System.out.println("get �������� �޾���");
			return "/user/login_register.jsp";   // �˻��� ����� ������ update form���� ����     	
	    }	

    	// POST request (ȸ�������� parameter�� ���۵�)
       	System.out.println("post �������� �޾���");
       	
//       email ��ġ��
       	String front_email = request.getParameter("front_email");
       	String domain = request.getParameter("domain");
       	String e_domain = request.getParameter("e_domain");
       	String email;
       	if(domain.equals("0"))
       		email = front_email + "@" + e_domain;
       	else
       		email = front_email + "@" + domain;
       	
//       	int user_id = Integer.parseInt(request.getParameter("user_id"));
		 User user = new User(
			0,
			request.getParameter("password"),
			request.getParameter("nickname"),
			email);
		
        log.debug("Create User : {}", user);

		try {
			UserManager manager = UserManager.getInstance();
			manager.create(user);
	        return "/course/course_keyword_select.jsp";		//���Ḹ �غ� ���� ��Ʈ�ѷ� ���� �� ��Ʈ�ѷ��� �����ؾ� �� �׸��� css ������ �ȵȴ�
	        
		} catch (ExistingUserException e) {	// ���� �߻� �� ȸ������ form���� forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			System.out.println("ȸ������ �� ���� �߻�");
			return "/user/login_register.jsp";
		}
    }
}
