package repository.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Comment;
import model.Reply;
import repository.mybatis.mapper.CommentMapper;

public class CommentMapperRepository {
	private SqlSessionFactory sqlSessionFactory;
	
	public CommentMapperRepository() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Comment> selectAllComments(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectAllComments();			
		} finally {
			sqlSession.close();
		}
	}
	
	//selectCommentsByPrimaryKeyAssociation �߰�
	public Comment selectCommentsByPrimaryKeyAssociation(long commentNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentsByPrimaryKeyAssociation(commentNo);			
		} finally {
			sqlSession.close();
		}
	}
	
	public Comment selectCommentByPrimaryKey(long commentNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentByPrimaryKey(commentNo);			
		} finally {
			sqlSession.close();
		}
	}

	public List<Comment> selectCommentByCondition(Map<String, Object> condition) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(CommentMapper.class).selectCommentByCondition(condition);			
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).insertComment(comment);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public int updateComment(Comment comment) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).updateComment(comment);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteComment(long commentNo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).deleteComment(commentNo);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteAllComments() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).deleteAllComments();
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;		
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertReply(Reply reply) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).insertReply(reply);
			if (result > 0) {
				sqlSession.commit();
			} 			
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteAllReplies() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(CommentMapper.class).deleteAllReplies();
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
}