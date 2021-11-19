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
	
	//user가 좋아한 course를 course_like 테이블에 행으로 추가
	public int create(int user_id, int course_id) throws SQLException {
		String sql = "INSERT INTO COURSE_LIKE VALUES (?, ?)";		
		Object[] param = new Object[] {user_id, course_id};				
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
		
		//user가 좋아한 course를 course_like 테이블에서 삭제
	public int remove(int user_id, int course_id) throws SQLException {
		String sql = "DELETE FROM COURSE_LIKE WHERE user_id=? AND course_id=? ";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id, course_id});	// JDBCUtil에 delete문과 매개 변수 설정
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
		
	//course_id로 like 개수 반환
	public int countLike(int course_id) throws SQLException {
		String sql = "SELECT COUNT(*) AS num FROM COURSE_LIKE WHERE course_id=? ";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});	// JDBCUtil에 delete문과 매개 변수 설정
		int likeCount = -1;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						
				likeCount = rs.getInt("num");
				return likeCount;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}		
		return likeCount;
	}
	
	//user_id로 <Course>courseList 반환
	public List<Course> user_likeCourseList(int user_id) throws SQLException {
        String sql = "SELECT course_id " 
        		   + "FROM USER_INFO u JOIN COURSE_LIKE c ON u.user_id = c.user_id "
        		   + "WHERE user_id=? ";
        jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행			
			List<Course> courseList = new ArrayList<Course>();	// User들의 리스트 생성
			while (rs.next()) {
				Course course = new Course(
//					경민이가 사용한 함수 사용하기
					rs.getInt("region_id"), rs.getString("region_name"));
				courseList.add(course);				// List에 User 객체 저장
			}		
			return courseList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
