package repository.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Music;
import repository.mybatis.mapper.MusicMapper;

public class MusicMapperRepository {
	private SqlSessionFactory sqlSessionFactory;
	
	public MusicMapperRepository() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public List<Music> selectAllMusics(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MusicMapper.class).selectAllMusics();			
		} finally {
			sqlSession.close();
		}
	}
	
	public Music selectMusicByMusicTag(String musicTag) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			return sqlSession.getMapper(MusicMapper.class).selectMusicByMusicTag(musicTag);			
		} finally {
			sqlSession.close();
		}
	}
	
	public int insertMusic(Music music) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MusicMapper.class).insertMusic(music);
			if (result > 0) {
				sqlSession.commit();
			} 
			return music.getMusicId();
		} finally {
			sqlSession.close();
		}
	}
	
	public int updateMusic(Music music) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MusicMapper.class).updateMusic(music);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteMusic(int musicId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MusicMapper.class).deleteMusic(musicId);
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;	
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteAllMusics() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			int result = sqlSession.getMapper(MusicMapper.class).deleteAllMusics();
			if (result > 0) {
				sqlSession.commit();
			} 
			return result;		
		} finally {
			sqlSession.close();
		}
	}
}
