package repository.mybatis.mapper;

import java.util.List;

import model.Comment;
import model.Music;

public interface MusicMapper {
	List<Music>selectAllMusics();
	
	List<Music>selectMusicByMusicTag(String musicTag);
	
	int insertMusic(Music music);   
	 
	int updateMusic(Music music);
	
	int deleteMusic(int musicId);

	int deleteAllMusics();
}
