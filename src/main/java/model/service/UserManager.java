package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Region;
import model.Theme;
import model.User;
import model.dao.UserDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;
//	private CourseDAO courseDAO;

	private UserManager() {
		try {
			userDAO = new UserDAO();
//			courseDAO = new CourseDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static UserManager getInstance() {
		return userMan;
	}
	
	public int create(User user) throws SQLException, ExistingUserException {
//		System.out.println("userid : " + user.getUser_id() + "usernickname : " + user.getNickname()
//		+ "userpassword : " + user.getPassword() + "useremail : " + user.getEmail());
//		if (user.getUser_id() == 0) {
//			throw new ExistingUserException("정보를 다 입력하지 않았습니다.");
//		}
		if (userDAO.existingUser(user.getEmail()) == true) {
			System.out.println("이메일 중복");
			throw new ExistingUserException(user.getEmail() + "는 존재하는 이메일입니다.");
		}
		return userDAO.create(user);
	}
	
	public int update(User user) throws SQLException, UserNotFoundException {
		return userDAO.update(user);
	}	
	
	public int remove(int user_id) throws SQLException, UserNotFoundException {
		return userDAO.remove(user_id);
	}
	
	public User findUser(int user_id)
			throws SQLException, UserNotFoundException {
			User user = userDAO.findUser(user_id);
			
			if (user == null) {
				throw new UserNotFoundException(user_id + "는 존재하지 않는 아이디 입니다.");
			}		
			return user;
		}
	
	public User findUserId(String email)
		throws SQLException, UserNotFoundException {
		User user = userDAO.findUserId(email);
		
		if (user == null) {
			throw new UserNotFoundException(email + "는 존재하지 않는 이메일 입니다.");
		}		
		return user;
	}

	public List<Region> regionList(int user_id) throws SQLException {
			return userDAO.user_regionList(user_id);
	}
	
	public List<Theme> themeList(int user_id) throws SQLException {
		return userDAO.user_themeList(user_id);
	}

	public boolean login(String email, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		User user = findUserId(email);
	
		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	public boolean existingUser(String email) throws SQLException, UserNotFoundException {
		return userDAO.existingUser(email);
	}	
	
	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	public int createRegion(int user_id, int region_id) throws SQLException {
		return userDAO.createUserR(user_id,  region_id);
	}

	public int createTheme(int user_id, int theme_id) throws SQLException {
		return userDAO.createUserT(user_id,  theme_id);
	}
}
