package model.service;

import java.sql.SQLException;
import java.util.List;

import model.Region;
import model.Theme;
import model.User;
import model.dao.UserDAO;

/**
 * ����� ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * UserDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� �ϸ�,
 * �����ͺ��̽��� �����͵��� �̿��Ͽ� �����Ͻ� ������ �����ϴ� ������ �Ѵ�.
 * �����Ͻ� ������ ������ ��쿡�� �����Ͻ� �������� �����ϴ� Ŭ������ 
 * ������ �� �� �ִ�.
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
//			throw new ExistingUserException("������ �� �Է����� �ʾҽ��ϴ�.");
//		}
		if (userDAO.existingUser(user.getEmail()) == true) {
			System.out.println("�̸��� �ߺ�");
			throw new ExistingUserException(user.getEmail() + "�� �����ϴ� �̸����Դϴ�.");
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
				throw new UserNotFoundException(user_id + "�� �������� �ʴ� ���̵� �Դϴ�.");
			}		
			return user;
		}
	
	public User findUserId(String email)
		throws SQLException, UserNotFoundException {
		User user = userDAO.findUserId(email);
		
		if (user == null) {
			throw new UserNotFoundException(email + "�� �������� �ʴ� �̸��� �Դϴ�.");
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
			throw new PasswordMismatchException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
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
