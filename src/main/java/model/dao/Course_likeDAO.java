package model.dao;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Region;
import model.Theme;

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
        String sql =  "SELECT c.course_id, course_name, departure, stopover, destination, time, parking, region_id, cl.user_id, t.theme_id, theme_name "
	             + "FROM Course c, THEME_COURSE tc, THEME t, COURSE_LIKE cl "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id AND c.course_id = cl.course_id "
	             + "AND cl.user_id=? "
	             + "ORDER BY c.course_id ";
        
        jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});		// JDBCUtil�� query�� ����
					
        try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query ����
		       List<Course> courseList = new ArrayList<Course>();   // course���� ����Ʈ ����
		       Course c = null;
		       List<Theme> themeList = new ArrayList<Theme>();
		       int preT = 0;
		       while (rs.next()) {
		    	   if (preT == Integer.parseInt(rs.getString("course_id"))) {
		    		   Theme t = new Theme(rs.getInt("theme_id"), rs.getString("theme_name"));
		 	          themeList.add(t);
		    	   }
		    	   else {
		    		   if(themeList.size() != 0) {
		        		c.setThemeList(themeList);
		        		courseList.add(c);
		        		themeList = new ArrayList<Theme>();
		        		}
		        		c = new Course(         // Course ��ü�� �����Ͽ� ���� ���� ������ ����
		        				rs.getInt("course_id"),
		          				rs.getString("course_name"),
		          				rs.getString("departure"),
		          				rs.getString("stopover"),
		          				rs.getString("destination"),
		          				rs.getString("time"),
		          				rs.getInt("parking"),
		          				rs.getInt("region_id"),
		          				themeList,
		          				rs.getInt("user_id"));
		        		
		        		preT = rs.getInt("course_id");
		       		   	
		  	          Theme t = new Theme(rs.getInt("theme_id"), rs.getString("theme_name"));
		  	          themeList.add(t);
		    	   }
		    	       
		       }

	    	   if(themeList.size() != 0) {
	        		c.setThemeList(themeList);
	        		courseList.add(c);
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
