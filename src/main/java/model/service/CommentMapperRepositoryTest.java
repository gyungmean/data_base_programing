package model.service;


import java.sql.SQLException;
import java.util.*;

import model.Comment;
import model.Course;
import model.Reply;
import model.User;
import repository.mybatis.CommentMapperRepository;

public class CommentMapperRepositoryTest {
	static CommentManager commentMan = CommentManager.getInstance();
//	static ReplyManager replyMan = ReplyManager.getInstance();
	public static void main(String[] args) throws SQLException, CourseNotFoundException, UserNotFoundException {
		System.out.println("CommentMapperRepository starts...");
		
		CourseManager courseMan = CourseManager.getInstance();
		Course course1 = courseMan.courseInfo(1);
		Course course2 = courseMan.courseInfo(2);
		
		UserManager userMan = UserManager.getInstance();
		User user1 = userMan.findUser(1);
				
		try {
//			commentMan.insertComment(20200004L, 1, "제목1", "내용1", 1);
//			commentMan.insertComment(20200005L, 2, "제목2", "내용2", 2);
//			System.out.println();
			
//			commentMan.selectCommentByPrimaryKey(20200004L);
//			commentMan.selectCommentByPrimaryKey(20200005L);
//			commentMan.selectCommentByCondition(2);
//			System.out.println();
	
//			commentMan.updateComment(20200004L, "내용1바꿈");
//			commentMan.selectCommentByPrimaryKey(20200004L);
//			System.out.println();
			
//			commentMan.deleteComment(20200004L);
//			commentMan.selectCommentByPrimaryKey(20200004L);
//			System.out.println();		
			
//			commentMan.insertReply(1, 20200004L, 3, "20200004L번 게시물에 3번이 댓글달기");
//			commentMan.insertReply(2, 20200004L, 1, "20200004L번 게시물에 1번이 댓글달기");
//			commentMan.insertReply(3, 20200005L, 3, "20200005L번 게시물에 3번이 댓글달기");

//			commentMan.deleteAllReplies();
		} finally {
//			manager.deleteAllComments();
//			manager.selectCommentByPrimaryKey(20200004L);
		}
	}
	

}
