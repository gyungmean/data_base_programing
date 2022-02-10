package repository.mybatis.mapper;

import java.util.List;
import java.util.Map;

import model.Comment;
import model.Reply;

public interface CommentMapper {
	Comment selectCommentByPrimaryKey(long commentNo);
	
	List<Comment> selectCommentByCondition(Map<String, Object> condition);
	
	int insertComment(Comment comment);   
 
	int updateComment(Comment comment);
	
	int deleteComment(long commentNo);

	int deleteAllComments();
	
	int insertReply(Reply reply);
	
	int deleteAllReplies();
}
