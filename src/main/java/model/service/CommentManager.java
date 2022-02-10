package model.service;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Comment;
import model.Course;
import model.Reply;
import model.User;
import model.dao.UserDAO;
import repository.mybatis.CommentMapperRepository;

public class CommentManager {
	private static CommentManager commentMan = new CommentManager();
	private static CommentMapperRepository commentDAO;
//	private CourseDAO courseDAO;

	private CommentManager() {
		try {
			commentDAO = new CommentMapperRepository();
//			courseDAO = new CourseDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static CommentManager getInstance() {
		return commentMan;
	}
	
//	commentNo·Î comment°´Ã¼ ¹ÝÈ¯
	public void selectCommentByPrimaryKey(Long commentNo) {		
		Comment comment = commentDAO.selectCommentByPrimaryKey(commentNo);
		System.out.println("selectCommentByPrimaryKey(" + commentNo + "): ");
		System.out.println(comment);
	}

//	userId·Î comment°´Ã¼ ¹ÝÈ¯
	public void selectCommentByCondition(int userId) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("userId", userId);
		List<Comment> list = commentDAO.selectCommentByCondition(condition);
		System.out.println("selectCommentByCondition(" + userId + "): ");
		System.out.println(list);
	}
	
	public void insertComment(Long commentNo, int userId, String title, String commentContent, int courseId) {
		Date regDate = Calendar.getInstance().getTime();		
		Comment comment = new Comment();
		comment.setCommentNo(commentNo);
		comment.setTitle(title);
		comment.setUserId(userId);
		comment.setCommentContent(commentContent);
		comment.setCourseId(courseId);
		comment.setRegDate(regDate);
		
		System.out.println("manager : " + comment);
		long result = commentDAO.insertComment(comment);
		System.out.println("insertComment(" + commentNo + ", ...): " + result);
	}
	
	public void updateComment(Long commentNo, String commentContent) {
		Comment comment = new Comment();
		comment.setCommentNo(commentNo);
		comment.setCommentContent(commentContent);

		int result = commentDAO.updateComment(comment);
		System.out.println("updateComment(" + commentNo + ", " + commentContent + "): " + result);
	}

	public void deleteComment(Long commentNo) {
		int result = commentDAO.deleteComment(commentNo);
		System.out.println("deleteComment(" + commentNo + "): " + result);
	}		
	
	public void deleteAllComments() {		
		int result = commentDAO.deleteAllComments();
		System.out.println("deleteAllComments(): " + result);
	}	
	
	public void insertReply(long replyId, long commentNo, int userId, String replyContent) {
		Reply reply = new Reply(replyId, commentNo, userId, replyContent, 
								Calendar.getInstance().getTime());
		long result = commentDAO.insertReply(reply);		
		System.out.println("insertReply(" + replyId + ", " + commentNo + ",...): " + result);
	}
	
	public void deleteAllReplies() {		
		int result = commentDAO.deleteAllReplies();
		System.out.println("deleteAllReplys(): " + result);
	}
	
}