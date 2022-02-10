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
//			commentMan.insertComment(20200004L, 1, "�젣紐�1", "�궡�슜1", 1);
//			commentMan.insertComment(20200005L, 2, "�젣紐�2", "�궡�슜2", 2);
//			System.out.println();
			
//			commentMan.selectCommentByPrimaryKey(20200004L);
//			commentMan.selectCommentByPrimaryKey(20200005L);
//			commentMan.selectCommentByCondition(2);
//			System.out.println();
	
//			commentMan.updateComment(20200004L, "�궡�슜1諛붽퓞");
//			commentMan.selectCommentByPrimaryKey(20200004L);
//			System.out.println();
			
//			commentMan.deleteComment(20200004L);
//			commentMan.selectCommentByPrimaryKey(20200004L);
//			System.out.println();		
			
//			commentMan.insertReply(1, 20200004L, 3, "20200004L踰� 寃뚯떆臾쇱뿉 3踰덉씠 �뙎湲��떖湲�");
//			commentMan.insertReply(2, 20200004L, 1, "20200004L踰� 寃뚯떆臾쇱뿉 1踰덉씠 �뙎湲��떖湲�");
//			commentMan.insertReply(3, 20200005L, 3, "20200005L踰� 寃뚯떆臾쇱뿉 3踰덉씠 �뙎湲��떖湲�");

//			commentMan.deleteAllReplies();
			
//			commentMan.insertComment(20200004L, 1, "제목1", "내용1", 1);
//			commentMan.insertComment(20200005L, 2, "제목2", "내용2", 2);
			
//			commentMan.insertReply(20200444L, 1, 3, "1번 게시물에 유저 3번이 댓글달음");
//			commentMan.insertReply(20200444L, 2, 2, "2번 게시물에 유저 2번이 댓글달음");
		} finally {
//			manager.deleteAllComments();
//			manager.selectCommentByPrimaryKey(20200004L);
		}
	}
	

}
