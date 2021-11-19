package model.service;

import java.sql.SQLException;

import model.User;
import model.dao.Course_likeDAO;
import model.dao.UserDAO;

public class Course_likeManager {
	private static Course_likeManager course_likeMan = new Course_likeManager();
	private Course_likeDAO course_likeDAO;
	
	private Course_likeManager() {
		try {
			course_likeDAO = new Course_likeDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static Course_likeManager getInstance() {
		return course_likeMan;
	}
	
	public int createLike(int user_id, int course_id) throws SQLException, ExistingUserException {
		return course_likeDAO.create(user_id, course_id);
	}	
	
	public int removeLike(int user_id, int course_id) throws SQLException, UserNotFoundException {
		return course_likeDAO.remove(user_id, course_id);
	}
	
	public int countLike(int course_id) throws SQLException, UserNotFoundException {
		return course_likeDAO.countLike(course_id);
	}
}
