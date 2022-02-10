package controller.comments;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.RegisterUserController;
import model.Comment;
import model.service.UserManager;
import repository.mybatis.CommentMapperRepository;

public class ListCommentsController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(ListCommentsController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("ListCommentController start");
		CommentMapperRepository commentDao = new CommentMapperRepository();
		
		List<Comment> commentsList = commentDao.selectAllComments();
		log.debug("selectAllComments success");
//		for(Comment c : commentsList) {
//			c = commentDao.selectCommentsByPrimaryKeyAssociation(c.getCommentNo());
//		}
		
		UserManager manager = UserManager.getInstance();
		for(Comment c : commentsList) {
			c.setUser(manager.getUserDAO().findUser(c.getUserId()));
		}
		
		request.setAttribute("commentsList", commentsList);
		
		return "/comments/comments_list.jsp";
	}

}
