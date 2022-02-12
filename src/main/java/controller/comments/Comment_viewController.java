package controller.comments;

import java.util.ArrayList;
import java.util.Date;
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
import model.service.Course_likeManager;
import model.service.UserManager;

public class Comment_viewController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

    	CommentManager comMan = CommentManager.getInstance();
    	UserManager userMan = UserManager.getInstance();

    	int user_id; 
    	User user;


		long commentNo = Long.parseLong(request.getParameter("commentNo"));
		
    	try {
			
			HttpSession session = request.getSession();
	    	user_id = UserSessionUtils.getLoginUserId(session);
    		user = userMan.findUser(user_id);
    		
        	if (request.getMethod().equals("POST")) {	
        		// post로 오면 댓글이 추가 되었다는 뜻
        		System.out.println("post로 들어옴");
        		comMan.insertReply( commentNo, user_id, request.getParameter("replyContent"));		
    	    }
	        
		} catch (Exception e) {	

    		user = new User(-1, "1010", "방문자", "chch@naver.com" );
		}

		request.setAttribute("user",user);	
    	
    	
    	List<Reply> replyList = new ArrayList<Reply>();
		

		
		Comment comment = new Comment();
		replyList = comMan.selectCommentByPrimaryKeyCollection(commentNo);
		
		comment = comMan.selectCommentByPrimaryKey(commentNo);

		request.setAttribute("comment", comment);
		request.setAttribute("replyList",replyList);
		
		return "/comments/comments_view.jsp";			
    }
}
