package controller.music;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.Controller;
import controller.music.*;
import controller.user.UserSessionUtils;
import model.Music;
import model.service.UserManager;
import repository.mybatis.MusicMapperRepository;

public class ListMusicController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ListMusicController.class);
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("ListMusicController start");
		MusicMapperRepository musicDao = new MusicMapperRepository();
		
		List<Music> musicList = musicDao.selectAllMusics();
		log.debug("selectAllMusic success");

		try {
			HttpSession session = request.getSession();
	    	int userId = UserSessionUtils.getLoginUserId(session);
	    	log.debug("userId: " + userId);
	    	
			request.setAttribute("userId", userId);
		} catch(Exception e) {
			request.setAttribute("userId", 0);
		}
		
		UserManager manager = UserManager.getInstance();

		request.setAttribute("musicList", musicList);
		request.setAttribute("controller", "List");
		return "/music/music_list.jsp";
	}
}
