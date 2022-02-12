package controller.music;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Music;
import model.service.MusicManager;

public class FindMusicController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String search_word = request.getParameter("search_word");
		
		MusicManager manager = MusicManager.getInstance();
		
		List<Music> musicList = manager.selectMusicByMusicTag(search_word);
		
		request.setAttribute("search_word", search_word);
		request.setAttribute("musicList", musicList);
		
		return "/music/music_list.jsp";
	}

}
