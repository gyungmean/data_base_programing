package repository.mybatis.mapper;

import java.util.List;
import java.util.Map;

import model.Comment;
import model.Reply;

public interface CommentMapper {
	List<Comment>selectAllComments();
	
	Comment selectCommentsByPrimaryKeyAssociation(long commentNo);
	
	Comment selectCommentByPrimaryKey(long commentNo);
	
	List<Comment> selectCommentsByUserId(int userId);
	
	List<Comment> selectCommentsByCourseId(int userId);
	
	List<Comment> selectCommentByCondition(Map<String, Object> condition);
	
	Comment selectCommentByPrimaryKeyCollection(long commentNo);
	
	int insertComment(Comment comment);   
 
	int updateComment(Comment comment);
	
	int deleteComment(long commentNo);

	int deleteAllComments();
	
	int insertReply(Reply reply);
	
	int deleteAllReplies();
}
