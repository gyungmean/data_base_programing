package model.service;

import java.util.Calendar;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import model.Comment;
import model.Music;
import repository.mybatis.CommentMapperRepository;
import repository.mybatis.MusicMapperRepository;
import repository.mybatis.mapper.CommentMapper;

public class MusicManager {
	private static MusicManager musicMan = new MusicManager();
	private static MusicMapperRepository musicDAO;
	
	private MusicManager() {
		try {
			musicDAO = new MusicMapperRepository();
//			courseDAO = new CourseDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static MusicManager getInstance() {
		return musicMan;
	}
	
	public void selectMusicByMusicTag(String musicTag) {
		Music music = musicDAO.selectMusicByMusicTag(musicTag);
		System.out.println("selectMusicByMusicTag(" + musicTag + "): ");
		System.out.println(music);
	}
	
	public void insertMusic(String musicTitle, String musicUrl, String musicTag, int userId) {		
		Music music = new Music();
		music.setMusicTitle(musicTitle);
		music.setMusicUrl(musicUrl);
		music.setMusicTag(musicTag);
		music.setUserId(userId);
		
		System.out.println("manager : " + music);
		int result = musicDAO.insertMusic(music);
		System.out.println("musicComment(" + result + ", ...): " + result);
	}
	
	public void updateMusic(int musicId, String musicUrl) {
		Music music = new Music();
		music.setMusicId(musicId);
		music.setMusicUrl(musicUrl);

		int result = musicDAO.updateMusic(music);
		System.out.println("updateMusic(" + musicId + ", " + musicUrl + "): " + result);
	}

	public void deleteMusic(int musicId) {
		int result = musicDAO.deleteMusic(musicId);
		System.out.println("deleteMusic(" + musicId + "): " + result);
	}		
	
	public void deleteAllMusics() {		
		int result = musicDAO.deleteAllMusics();
		System.out.println("deleteAllMusics(): " + result);
	}	
}
