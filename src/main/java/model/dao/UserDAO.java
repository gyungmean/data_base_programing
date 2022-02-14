package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Region;
import model.Theme;
import model.User;

/**
 * ����� ������ ���� �����ͺ��̽� �۾��� �����ϴ� DAO Ŭ����
 * USERINFO ���̺� ����� ������ �߰�, ����, ����, �˻� ���� 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}
		
	/**
	 * ����� ���� ���̺� ���ο� ����� ����.
	 */
	public int create(User user) throws SQLException {
		String sql = "INSERT INTO USER_INFO VALUES (user_id_Seq.nextval, ?, ?, ?)";		
		Object[] param = new Object[] {user.getPassword(), 
						user.getNickname(), user.getEmail()	};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
//		String key[] = {"user_id"};
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;			
	}

	/**
	 * ������ ����� ������ ����.
	 */

	public int update(User user) throws SQLException {
		String sql = "UPDATE USER_INFO "
					+ "SET password=?, nickname=?, email=? "
					+ "WHERE user_id=?";
		Object[] param = new Object[] {user.getPassword(), user.getNickname(), 
					user.getEmail(), user.getUser_id()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�� update���� �Ű� ���� ����
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}
	
	public int updateNickName(int user_id, String nickName) throws SQLException {
		String sql = "UPDATE USER_INFO "
					+ "SET nickname=? "
					+ "WHERE user_id=?";
		Object[] param = new Object[] {nickName, user_id};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil�� update���� �Ű� ���� ����
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * ����� ID�� �ش��ϴ� ����ڸ� ����.
	 */
	public int remove(int user_id) throws SQLException {
		String sql = "DELETE FROM USER_INFO WHERE user_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil�� delete���� �Ű� ���� ����

		try {				
			int result = jdbcUtil.executeUpdate();	// delete �� ����
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;
	}

	/**
	 * �־��� ����� ID�� �ش��ϴ� ����� ������ �����ͺ��̽����� ã�� User ������ Ŭ������ 
	 * �����Ͽ� ��ȯ.
	 */
	public User findUser(int user_id) throws SQLException {
        String sql = "SELECT password, nickname, email "
        			+ "FROM USER_INFO "
        			+ "WHERE user_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// �л� ���� �߰�
				User user = new User(		// User ��ü�� �����Ͽ� �л� ������ ����
					user_id,
					rs.getString("password"),
					rs.getString("nickname"),
					rs.getString("email"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	public User findUserId(String email) throws SQLException {
        String sql = "SELECT user_id, password, nickname "
        			+ "FROM USER_INFO "
        			+ "WHERE email=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {email});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						// �л� ���� �߰�
				User user = new User(		// User ��ü�� �����Ͽ� �л� ������ ����
					rs.getInt("user_id"),
					rs.getString("password"),
					rs.getString("nickname"),
					email);
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}

	/**
	 * ��ü ����� ������ �˻��Ͽ� List�� ���� �� ��ȯ
	 */
//	������� ��ȣ�ϴ� ���� ����Ʈ ��ȯ
	public List<Region> user_regionList(int user_id) throws SQLException {
        String sql = "SELECT r.region_id, r.region_name " 
        		   + "FROM USER_REGION u JOIN REGION r ON u.region_id = r.region_id "
        		   + "WHERE user_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����			
			List<Region> regionList = new ArrayList<Region>();	// User���� ����Ʈ ����
			while (rs.next()) {
				Region region = new Region(		
					rs.getInt("region_id"), rs.getString("region_name"));
				regionList.add(region);				// List�� User ��ü ����
			}		
			return regionList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
//	������� ��ȣ�ϴ� �׸� ����Ʈ ��ȯ
	public List<Theme> user_themeList(int user_id) throws SQLException {
        String sql = "SELECT t.theme_id, t.theme_name " 
        		   + "FROM USER_THEME u JOIN THEME t ON u.theme_id = t.theme_id "
        		   + "WHERE user_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����			
			List<Theme> themeList = new ArrayList<Theme>();	// User���� ����Ʈ ����
			while (rs.next()) {
				Theme theme = new Theme(		
					rs.getInt("theme_id"), rs.getString("theme_name"));
				themeList.add(theme);				// List�� User ��ü ����
			}		
			return themeList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	/**
	 * �־��� ����� email�� �ش��ϴ� ����ڰ� �����ϴ��� �˻� 
	 */
	public boolean existingUser(String email) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE email=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {email});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return false;
	}
	
	public int createUserR(int user_id, int region_id) throws SQLException {
		System.out.println("UserDao region ����");
		System.out.println("user_id : " + user_id + "\nregion_id : " + region_id);
		
		String sql = "INSERT INTO USER_REGION VALUES (?, ?)";		
		Object[] param = new Object[] {user_id, region_id};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
		
		try {				
			int result = jdbcUtil.executeUpdate();	// insert �� ����
			System.out.println("UserDao region ����");
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;			
	}
	
	public int createUserT(int user_id, int theme_id) throws SQLException {
		System.out.println("UserDao theme ����");
		System.out.println("user_id : " + user_id + "\ntheme_id : " + theme_id);
		
		String sql = "INSERT INTO USER_THEME VALUES (?, ?)";		
		Object[] param = new Object[] {user_id, theme_id};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil �� insert���� �Ű� ���� ����
					
		try {				
			int result = jdbcUtil.executeUpdate();	// insert �� ����
			System.out.println("UserDao theme ����");
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource ��ȯ
		}		
		return 0;			
	}
	

}
