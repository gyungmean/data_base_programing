package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Theme;

public class CourseDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CourseDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	 /**
     * 코스 관리 테이블에 새로운 코스 생성.
     */
 public int create(Course course) throws SQLException {
    String sql = "INSERT INTO COURSE VALUES (courseId_Seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";      
    Object[] param = new Object[] {course.getCourse_name(),
                            (course.getDeparture()!= null) ? course.getDeparture() : null, 
                            (course.getStopover()!= null) ? course.getStopover() : null,
                            (course.getDestination()!= null) ? course.getDestination() : null,
                            course.getTime(), ((course.getParking() != 0) ? course.getParking() : null), 
                            course.getRegion_id()};            
    
    jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정
     String key[] = {"course_id"};
    try {            
       int result = jdbcUtil.executeUpdate(key);   // insert 문 실행
       ResultSet rs = jdbcUtil.getGeneratedKeys();
       int generatedKey = 0;
       if (rs.next()) {
          generatedKey = rs.getInt(1);
       }
       return generatedKey;
    } catch (Exception ex) {
       jdbcUtil.rollback();
       ex.printStackTrace();
    } finally {      
       jdbcUtil.commit();
       jdbcUtil.close();   // resource 반환
    }      
    return 0;         
 }
 
 //course theme 저장
 public int theme(int theme_id, int course_id) throws SQLException {
    String sql = "INSERT INTO THEME_COURSE VALUES (?, ?)";      
    Object[] param = new Object[] {theme_id, course_id};            
    
    jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil 에 insert문과 매개 변수 설정
                   
    try {            
       int result = jdbcUtil.executeUpdate();   // insert 문 실행
       return result;
    } catch (Exception ex) {
       jdbcUtil.rollback();
       ex.printStackTrace();
    } finally {      
       jdbcUtil.commit();
       jdbcUtil.close();   // resource 반환
    }      
    return 0;         
 }

 
    /**
     * 코스 ID에 해당하는 코스를 삭제.
     */
 public int remove(int course_id) throws SQLException {
    String sql = "DELETE FROM Course WHERE course_id=?";      
    jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});   // JDBCUtil에 delete문과 매개 변수 설정

    try {            
       int result = jdbcUtil.executeUpdate();   // delete 문 실행
       return result;
    } catch (Exception ex) {
       jdbcUtil.rollback();
       ex.printStackTrace();
    }
    finally {
       jdbcUtil.commit();
       jdbcUtil.close();   // resource 반환
    }      
    return 0;
 }
   
    /**
     * 코스 이름으로 아이디 스트링 리스트 반환
     */

 // 채연 코드
 public List<Course> findCourse(String course_name) throws SQLException {
	    String sql = "SELECT c.course_id, course_name, time, region_id, t.theme_id, theme_name "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	             + "AND course_name LIKE ?"
	             + "ORDER BY c.course_id";                   
	    jdbcUtil.setSqlAndParameters(sql, new Object[] {"%" + course_name + "%"});   // JDBCUtil에 query문과 매개 변수 설정
	    
	    try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query 실행
		       List<Course> courseList = new ArrayList<Course>();   // course들의 리스트 생성
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
		        		c = new Course(         // Course 객체를 생성하여 현재 행의 정보를 저장
				        		rs.getInt("course_id"),
								rs.getString("course_name"),
								null,
								null,
								null,
								rs.getString("time"),
								0,
								rs.getInt("region_id"),
								themeList,
								0);
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
	       jdbcUtil.close();      // resource 반환
	    }
	    return null;
	 }
 
 
 public Course findCourseById(int course_id) throws SQLException {
	    String sql = "SELECT course_id, course_name, time, region_id, theme_id, theme_name "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	             + " AND course_id=?";    
	    
	    jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});   // JDBCUtil에 query문과 매개 변수 설정


	    try {
	       ResultSet rs = jdbcUtil.executeQuery();      // query 실행
	       List<Theme> themeList = new ArrayList<Theme>();
	       Course c = null;
	       if (rs.next()) {
	    	   
	          c = new Course(         // Course 객체를 생성하여 현재 행의 정보를 저장
	        		rs.getInt("course_id"),
					rs.getString("course_name"),
					null,
					null,
					null,
					rs.getString("time"),
					0,
					rs.getInt("region_id"),
					themeList,
					0);
	          Theme t = new Theme(rs.getInt("theme_id"), rs.getString("theme_name"));
	          themeList.add(t);
	       }  
	       while(rs.next()) {
	       	  Theme t = new Theme(rs.getInt("theme_id"), rs.getString("theme_name"));
	          themeList.add(t);
	       }
	       c.setThemeList(themeList);
	       return c;
	    } catch (Exception ex) {
	       ex.printStackTrace();
	    } finally {
	       jdbcUtil.close();      // resource 반환
	    }
	    return null;
	 }
	
	//선호 키워드 선택 안한 사람들한테 보일 코스매칭 화면 리스트
	public List<Course> allCourseList() throws SQLException {
		String sql = "SELECT c.course_id, course_name, time, region_id, t.theme_id, t.theme_name "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
				+ "ORDER BY c.course_id ";

		
		jdbcUtil.setSqlAndParameters(sql, null);						
		
		try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query 실행
		       List<Course> courseList = new ArrayList<Course>();   // course들의 리스트 생성
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
		        		c = new Course(         // Course 객체를 생성하여 현재 행의 정보를 저장
				        		rs.getInt("course_id"),
								rs.getString("course_name"),
								null,
								null,
								null,
								rs.getString("time"),
								0,
								rs.getInt("region_id"),
								themeList,
								0);
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
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
//	//선호 키워드 따라서 정렬하는 함수(중간때는 보류)
//	public List<Course> keywordCourseList(int currentPage, int countPerPage, int user_id) throws SQLException {
//		String sql_1 = "SELECT cousre_id, course_name, like_count, time, region_id "
//					+ "FROM COURSE "
//					+ "";
//		jdbcUtil.setSqlAndParameters(sql_1, null,					// JDBCUtil에 query문 설정
//				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
//				ResultSet.CONCUR_READ_ONLY);
//		String sql_2 = "SELECT cousre_id, course_name, like_count, time, region_id, theme_id "
//				+ "FROM Course "
//				+ "where NOT (region_id=? AND theme_id=?)";
//		
//		List<Course> courseList = new ArrayList<Course>();
//		try {
//			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
////			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
//			do {
//				Course course = new Course(	
//				rs.getInt("course_id"),
//				rs.getString("course_name"),
//				null,
//				null,
//				null,
//				rs.getString("time"),
//				0,
//				rs.getInt("like_count"),
//				rs.getInt("region_id"),
//				rs.getInt("theme_id"));
//				courseList.add(course);					
//			} while ((rs.next()));		
//			return courseList;							
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} finally {
//			jdbcUtil.close();		// resource 반환
//		}
//		return null;
//	}
//	
	
	//조건 맞춰서 매칭 후 리스트
	public List<Course> matchCourse(String time, int region_id, List<String> themeString) throws SQLException {
        String sql = "SELECT c.course_id, course_name, time, region_id, t.theme_id, t.theme_name "
        		+ "FROM Course c, THEME_COURSE tc, THEME t "
	            + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	            + "AND t.theme_id IN (";
        
        for(String t : themeString) {
        	if(t == themeString.get(themeString.size() - 1)) {
        		sql += (t + ") ");
        		break;
        	}
        	sql += (t + ", ");
        }
        
        sql += "AND time=? AND region_id=? ";
       
        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {time, region_id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query 실행
		       List<Course> courseList = new ArrayList<Course>();   // course들의 리스트 생성
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
		        		c = new Course(         // Course 객체를 생성하여 현재 행의 정보를 저장
				        		rs.getInt("course_id"),
								rs.getString("course_name"),
								null,
								null,
								null,
								rs.getString("time"),
								0,
								rs.getInt("region_id"),
								themeList,
								0);
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
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	//상세보기
	public Course detailCourse(int course_id) throws SQLException{
		String sql = "SELECT c.course_id, course_name, departure, stopover, destination, time, parking, region_id, user_id, t.theme_id, t.theme_name "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	             + "AND c.course_id=? ";    
	    
	    jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});   // JDBCUtil에 query문과 매개 변수 설정


	    try {
	       ResultSet rs = jdbcUtil.executeQuery();      // query 실행
	       List<Theme> themeList = new ArrayList<Theme>();
	       Course c = null;
	       if (rs.next()) {
				c = new Course(
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
				
				Theme t = new Theme(rs.getInt("theme_id"), rs.getString("theme_name"));
		          themeList.add(t);
		          System.out.println(t.toString());
		   }  
		   while(rs.next()) {
		   	  Theme t = new Theme(rs.getInt("theme_id"), rs.getString("theme_name"));
		      themeList.add(t);
		   }
		   c.setThemeList(themeList);
		 return c;
		 
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
	   public boolean existingCourse(String course_name) throws SQLException {
	      String sql = "SELECT count(*) FROM COURSE WHERE course_name=?";      
	      jdbcUtil.setSqlAndParameters(sql, new Object[] {course_name});   // JDBCUtil에 query문과 매개 변수 설정

	      try {
	         ResultSet rs = jdbcUtil.executeQuery();      // query 실행
	         if (rs.next()) {
	            int count = rs.getInt(1);
	            return (count == 1 ? true : false);
	         }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close();      // resource 반환
	      }
	      return false;
	   }
}

