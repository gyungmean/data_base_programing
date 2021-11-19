package model.dao;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Region;

public class Course_likeDAO {
	private JDBCUtil jdbcUtil = null;
	
	public Course_likeDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	//user�� ������ course�� course_like ���̺� ������ �߰�
	public int create(int user_id, int course_id) throws SQLException {
		String sql = "INSERT INTO COURSE_LIKE VALUES (?, ?)";		
		Object[] param = new Object[] {user_id, course_id};				
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
		
		//user�� ������ course�� course_like ���̺��� ����
	public int remove(int user_id, int course_id) throws SQLException {
		String sql = "DELETE FROM COURSE_LIKE WHERE user_id=? AND course_id=? ";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id, course_id});	// JDBCUtil�� delete���� �Ű� ���� ����
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
		
	//course_id�� like ���� ��ȯ
	public int countLike(int course_id) throws SQLException {
		String sql = "SELECT COUNT(*) AS num FROM COURSE_LIKE WHERE course_id=? ";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});	// JDBCUtil�� delete���� �Ű� ���� ����
		int likeCount = -1;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����
			if (rs.next()) {						
				likeCount = rs.getInt("num");
				return likeCount;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}		
		return likeCount;
	}
	
	//user_id�� <Course>courseList ��ȯ
	public List<Course> user_likeCourseList(int user_id) throws SQLException {
        String sql = "SELECT course_id " 
        		   + "FROM USER_INFO u JOIN COURSE_LIKE c ON u.user_id = c.user_id "
        		   + "WHERE user_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});		// JDBCUtil�� query�� ����
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query ����			
			List<Course> courseList = new ArrayList<Course>();	// User���� ����Ʈ ����
			while (rs.next()) {
				Course course = new Course(
//					����̰� ����� �Լ� ����ϱ�
					rs.getInt("region_id"), rs.getString("region_name"));
				courseList.add(course);				// List�� User ��ü ����
			}		
			return courseList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
}
