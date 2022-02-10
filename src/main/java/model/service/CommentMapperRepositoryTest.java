package model.service;


import java.sql.SQLException;
import java.util.*;

import model.Comment;
import model.Course;
import model.Reply;
import model.User;
import repository.mybatis.CommentMapperRepository;

public class CommentMapperRepositoryTest {
	static CommentManager manager = CommentManager.getInstance();

	public static void main(String[] args) throws SQLException, CourseNotFoundException, UserNotFoundException {
		System.out.println("CommentMapperRepository starts...");
		
		CourseManager courseMan = CourseManager.getInstance();
		Course course1 = courseMan.courseInfo(1);
		Course course2 = courseMan.courseInfo(2);
		
		UserManager userMan = UserManager.getInstance();
		User user1 = userMan.findUser(1);
				
		try {
			manager.insertComment(20200004L, 1, "제목1", "내용1", 1);
			manager.insertComment(20200005L, 2, "제목2", "내용2", 2);
			System.out.println();
			
//			manager.selectCommentByPrimaryKey(20200004L);
//			manager.selectCommentByPrimaryKey(20200005L);
//			manager.selectCommentByCondition(1);
//			System.out.println();
//	
//			manager.updateComment(20200004L, "comment #0");
//			manager.selectCommentByCondition(1);
//			System.out.println();
//			
//			manager.deleteComment(20200004L);
//			manager.selectCommentByCondition(1);
//			System.out.println();			
		} finally {
//			manager.deleteAllComments();
//			manager.selectCommentByCondition(1);
		}
	}
	

}
