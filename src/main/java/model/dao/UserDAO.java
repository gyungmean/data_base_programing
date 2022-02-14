package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Region;
import model.Theme;
import model.User;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class UserDAO {
	private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
		
	/**
	 * 사용자 관리 테이블에 새로운 사용자 생성.
	 */
	public int create(User user) throws SQLException {
		String sql = "INSERT INTO USER_INFO VALUES (user_id_Seq.nextval, ?, ?, ?)";		
		Object[] param = new Object[] {user.getPassword(), 
						user.getNickname(), user.getEmail()	};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
//		String key[] = {"user_id"};
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}

	/**
	 * 기존의 사용자 정보를 수정.
	 */

	public int update(User user) throws SQLException {
		String sql = "UPDATE USER_INFO "
					+ "SET password=?, nickname=?, email=? "
					+ "WHERE user_id=?";
		Object[] param = new Object[] {user.getPassword(), user.getNickname(), 
					user.getEmail(), user.getUser_id()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	public int updateNickName(int user_id, String nickName) throws SQLException {
		String sql = "UPDATE USER_INFO "
					+ "SET nickname=? "
					+ "WHERE user_id=?";
		Object[] param = new Object[] {nickName, user_id};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(int user_id) throws SQLException {
		String sql = "DELETE FROM USER_INFO WHERE user_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public User findUser(int user_id) throws SQLException {
        String sql = "SELECT password, nickname, email "
        			+ "FROM USER_INFO "
        			+ "WHERE user_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				User user = new User(		// User 객체를 생성하여 학생 정보를 저장
					user_id,
					rs.getString("password"),
					rs.getString("nickname"),
					rs.getString("email"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	public User findUserId(String email) throws SQLException {
        String sql = "SELECT user_id, password, nickname "
        			+ "FROM USER_INFO "
        			+ "WHERE email=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {email});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				User user = new User(		// User 객체를 생성하여 학생 정보를 저장
					rs.getInt("user_id"),
					rs.getString("password"),
					rs.getString("nickname"),
					email);
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
//	사용자의 선호하는 지역 리스트 반환
	public List<Region> user_regionList(int user_id) throws SQLException {
        String sql = "SELECT r.region_id, r.region_name " 
        		   + "FROM USER_REGION u JOIN REGION r ON u.region_id = r.region_id "
        		   + "WHERE user_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행			
			List<Region> regionList = new ArrayList<Region>();	// User들의 리스트 생성
			while (rs.next()) {
				Region region = new Region(		
					rs.getInt("region_id"), rs.getString("region_name"));
				regionList.add(region);				// List에 User 객체 저장
			}		
			return regionList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
//	사용자의 선호하는 테마 리스트 반환
	public List<Theme> user_themeList(int user_id) throws SQLException {
        String sql = "SELECT t.theme_id, t.theme_name " 
        		   + "FROM USER_THEME u JOIN THEME t ON u.theme_id = t.theme_id "
        		   + "WHERE user_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행			
			List<Theme> themeList = new ArrayList<Theme>();	// User들의 리스트 생성
			while (rs.next()) {
				Theme theme = new Theme(		
					rs.getInt("theme_id"), rs.getString("theme_name"));
				themeList.add(theme);				// List에 User 객체 저장
			}		
			return themeList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 주어진 사용자 email에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String email) throws SQLException {
		String sql = "SELECT count(*) FROM USER_INFO WHERE email=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {email});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	
	public int createUserR(int user_id, int region_id) throws SQLException {
		System.out.println("UserDao region 성공");
		System.out.println("user_id : " + user_id + "\nregion_id : " + region_id);
		
		String sql = "INSERT INTO USER_REGION VALUES (?, ?)";		
		Object[] param = new Object[] {user_id, region_id};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
		
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			System.out.println("UserDao region 성공");
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}
	
	public int createUserT(int user_id, int theme_id) throws SQLException {
		System.out.println("UserDao theme 성공");
		System.out.println("user_id : " + user_id + "\ntheme_id : " + theme_id);
		
		String sql = "INSERT INTO USER_THEME VALUES (?, ?)";		
		Object[] param = new Object[] {user_id, theme_id};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
					
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			System.out.println("UserDao theme 성공");
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;			
	}
	

}
