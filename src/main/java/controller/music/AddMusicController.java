package controller.music;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Music;
import repository.mybatis.MusicMapperRepository;


public class AddMusicController implements Controller {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
	    	HttpSession session = request.getSession();
	    	int userId = UserSessionUtils.getLoginUserId(session);
	    	
	    	MusicMapperRepository musicDao = new MusicMapperRepository();
	    	Music music = new Music();
	    	
	    	try {
	    		String title = request.getParameter("musicTitle");
		    	String url= request.getParameter("musicUrl");
		    	String tag = request.getParameter("musicTag");
	    		
	    		music.setMusicTitle(title);
	    		music.setMusicUrl(url);
	    		music.setMusicTag(tag);
	    		music.setUserId(userId);
	    		
	    	} catch (Exception e) {
	    		return "/music/music_add.jsp";
	    	}
	    	
	    	musicDao.insertMusic(music);

			return "redirect:/music";
    }
}
