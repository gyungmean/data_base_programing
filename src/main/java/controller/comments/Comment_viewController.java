package controller.comments;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import controller.Controller;
import controller.user.UserSessionUtils;
import model.Comment;
import model.Reply;
import model.User;
import model.service.CommentManager;
import model.service.UserManager;

public class Comment_viewController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

    	CommentManager comMan = CommentManager.getInstance();
    	UserManager userMan = UserManager.getInstance();


    	HttpSession session = request.getSession();
    	int user_id = UserSessionUtils.getLoginUserId(session); // ���ǿ��� �α��� �� ���̵� �޾ƿ���
    	User user = userMan.findUser(user_id);
    	
    	List<Reply> replyList = new ArrayList<Reply>();

		long commentNo = Long.parseLong(request.getParameter("commentNo"));
		
		
		System.out.println(commentNo + "  " + user_id + request.getParameter("replyContent"));
    	if (request.getMethod().equals("POST")) {	
    		// post�� ���� ����� �߰� �Ǿ��ٴ� ��
    		System.out.println("post�� ����");
    		comMan.insertReply( commentNo, user_id, request.getParameter("replyContent"));		
	    }

		
		Comment comment = new Comment();
		replyList = comMan.selectCommentByPrimaryKeyCollection(commentNo);
		comment = comMan.selectCommentByPrimaryKey(commentNo);
		

		request.setAttribute("comment", comment);
		request.setAttribute("replyList",replyList);
		request.setAttribute("user",user);
		
		
		return "/comments/comments_view.jsp";			
    }
}
