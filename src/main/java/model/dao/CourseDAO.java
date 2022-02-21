
package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import model.Course;
import model.Region;
import model.Theme;

public class CourseDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CourseDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	 /**
     * �ڽ� ���� ���̺� ���ο� �ڽ� ����.
     */
	public int create(Course course) throws SQLException {
	    String sql = "INSERT INTO COURSE VALUES (course_id_Seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";      
	    Object[] param = new Object[] {course.getCourse_name(),
	                            (course.getDeparture()!= null) ? course.getDeparture() : null, 
	                            (course.getStopover()!= null) ? course.getStopover() : null,
	                            (course.getDestination()!= null) ? course.getDestination() : null,
	                            course.getTime(), ((course.getParking() != 0) ? course.getParking() : null), 
	                            course.getRegion_id(), course.getUser_id(), ((course.getUrl() != null) ? course.getUrl() : null)};            
	    
	    jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil �� insert���� �Ű� ���� ����
	     String key[] = {"course_id"};
	    try {            
	       int result = jdbcUtil.executeUpdate(key);   // insert �� ����
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
	       jdbcUtil.close();   // resource ��ȯ
	    }      
	    return 0;         
	 }
 
 //course theme ����
 public int theme(int theme_id, int course_id) throws SQLException {
    String sql = "INSERT INTO THEME_COURSE VALUES (?, ?)";      
    Object[] param = new Object[] {theme_id, course_id};            
    
    jdbcUtil.setSqlAndParameters(sql, param);   // JDBCUtil �� insert���� �Ű� ���� ����
                   
    try {            
       int result = jdbcUtil.executeUpdate();   // insert �� ����
       return result;
    } catch (Exception ex) {
       jdbcUtil.rollback();
       ex.printStackTrace();
    } finally {      
       jdbcUtil.commit();
       jdbcUtil.close();   // resource ��ȯ
    }      
    return 0;         
 }

 
    /**
     * �ڽ� ID�� �ش��ϴ� �ڽ��� ����.
     */
 public int remove(int course_id) throws SQLException {
    String sql = "DELETE FROM Course WHERE course_id=?";      
    jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});   // JDBCUtil�� delete���� �Ű� ���� ����

    try {            
       int result = jdbcUtil.executeUpdate();   // delete �� ����
       return result;
    } catch (Exception ex) {
       jdbcUtil.rollback();
       ex.printStackTrace();
    }
    finally {
       jdbcUtil.commit();
       jdbcUtil.close();   // resource ��ȯ
    }      
    return 0;
 }
   
    /**
     * �ڽ� �̸����� ���̵� ��Ʈ�� ����Ʈ ��ȯ
     */

 // ä�� �ڵ�
 public List<Course> findCourse(String course_name) throws SQLException {
	    String sql = "SELECT c.course_id, course_name, time, region_id, t.theme_id, theme_name, c.url "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	             + "AND course_name LIKE ?"
	             + "ORDER BY c.course_id";                   
	    jdbcUtil.setSqlAndParameters(sql, new Object[] {"%" + course_name + "%"});   // JDBCUtil�� query���� �Ű� ���� ����
	    
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
								null,
								null,
								null,
								rs.getString("time"),
								0,
								rs.getInt("region_id"),
								themeList,
								0,
								rs.getString("url"));
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
	       jdbcUtil.close();      // resource ��ȯ
	    }
	    return null;
	 }
 
 
 public Course findCourseById(int course_id) throws SQLException {
	    String sql = "SELECT course_id, course_name, time, region_id, theme_id, theme_name, c.url "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	             + " AND course_id=?";    
	    
	    jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});   // JDBCUtil�� query���� �Ű� ���� ����


	    try {
	       ResultSet rs = jdbcUtil.executeQuery();      // query ����
	       List<Theme> themeList = new ArrayList<Theme>();
	       Course c = null;
	       if (rs.next()) {
	    	   
	          c = new Course(         // Course ��ü�� �����Ͽ� ���� ���� ������ ����
	        		rs.getInt("course_id"),
					rs.getString("course_name"),
					null,
					null,
					null,
					rs.getString("time"),
					0,
					rs.getInt("region_id"),
					themeList,
					0,
					rs.getString("url"));
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
	       jdbcUtil.close();      // resource ��ȯ
	    }
	    return null;
	 }
	
	//��ȣ Ű���� ���� ���� ��������� ���� �ڽ���Ī ȭ�� ����Ʈ
	public List<Course> allCourseList() throws SQLException {
		String sql = "SELECT c.course_id, course_name, time, region_id, t.theme_id, t.theme_name, c.url "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
				+ "ORDER BY c.course_id ";

		
		jdbcUtil.setSqlAndParameters(sql, null);						
		
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
								null,
								null,
								null,
								rs.getString("time"),
								0,
								rs.getInt("region_id"),
								themeList,
								0,
								rs.getString("url")
		        				);
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
	
	//��ȣ Ű���� ���� �����ϴ� �Լ�(�߰����� ����)
	public LinkedHashSet<Integer> keywordCourseList(List<String> regionString, List<String> themeString) throws SQLException {
		String sql = "SELECT c.course_id "
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
		
		sql += "AND c.region_id IN (";
		
		for(String t : regionString) {
        	if(t == regionString.get(regionString.size() - 1)) {
        		sql += (t + ") ORDER BY c.course_id ");
        		break;
        	}
        	sql += (t + ", ");
        }
		System.out.println(sql);
		
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);
		
		
		try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query ����
		       LinkedHashSet<Integer> courseIdList = new LinkedHashSet<>();

		       while (rs.next()) {
		    	   courseIdList.add(rs.getInt("course_id"));    	  
		       }

	    	   return courseIdList; 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	public LinkedHashSet<Integer> keywordCourseList2(List<String> regionString, List<String> themeString) throws SQLException {
		String sql = "SELECT c.course_id "
        		+ "FROM Course c, THEME_COURSE tc, THEME t "
	            + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	            + "AND t.theme_id NOT IN (";
		
		for(String t : themeString) {
        	if(t == themeString.get(themeString.size() - 1)) {
        		sql += (t + ") ");
        		break;
        	}
        	sql += (t + ", ");
        }
		
		sql += "AND c.region_id IN (";
		
		for(String t : regionString) {
        	if(t == regionString.get(regionString.size() - 1)) {
        		sql += (t + ") ORDER BY c.course_id ");
        		break;
        	}
        	sql += (t + ", ");
        }
		System.out.println(sql);
		
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);
		
		
		try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query ����
		       LinkedHashSet<Integer> courseIdList = new LinkedHashSet<>();

		       while (rs.next()) {
		    	   courseIdList.add(rs.getInt("course_id"));    	  
		       }

	    	   return courseIdList; 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	public LinkedHashSet<Integer> keywordCourseList3(List<String> regionString, List<String> themeString) throws SQLException {
		String sql = "SELECT c.course_id "
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
		
		sql += "AND c.region_id NOT IN (";
		
		for(String t : regionString) {
        	if(t == regionString.get(regionString.size() - 1)) {
        		sql += (t + ") ORDER BY c.course_id ");
        		break;
        	}
        	sql += (t + ", ");
        }
		System.out.println(sql);
		
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
				ResultSet.CONCUR_READ_ONLY);
		
		
		try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query ����
		       LinkedHashSet<Integer> courseIdList = new LinkedHashSet<>();

		       while (rs.next()) {
		    	   courseIdList.add(rs.getInt("course_id"));    	  
		       }

	    	   return courseIdList; 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	//��ȣ Ű���� ���� �����ϴ� �Լ�(�߰����� ����)
		public LinkedHashSet<Integer> notKeywordCourseList(List<String> regionString, List<String> themeString) throws SQLException {
			String sql = "SELECT c.course_id "
	        		+ "FROM Course c, THEME_COURSE tc, THEME t "
		            + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
		            + "AND t.theme_id NOT IN (";
			
			for(String t : themeString) {
	        	if(t == themeString.get(themeString.size() - 1)) {
	        		sql += (t + ") ");
	        		break;
	        	}
	        	sql += (t + ", ");
	        }
			
			sql += "AND c.region_id NOT IN (";
			
			for(String t : regionString) {
	        	if(t == regionString.get(regionString.size() - 1)) {
	        		sql += (t + ") ORDER BY c.course_id ");
	        		break;
	        	}
	        	sql += (t + ", ");
	        }
			
			jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil�� query�� ����
					ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll ����
					ResultSet.CONCUR_READ_ONLY);
			
			
			try {
					ResultSet rs = jdbcUtil.executeQuery();      // query ����
			       LinkedHashSet<Integer> courseIdList = new LinkedHashSet<>();

			       while (rs.next()) {
			    	   courseIdList.add(rs.getInt("course_id"));    	  
			       }

		    	   return courseIdList;  
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource ��ȯ
			}
			return null;
		}
	
	
	//���� ���缭 ��Ī �� ����Ʈ
	public LinkedHashSet<Integer> matchCourse(String time, int region_id, List<String> themeString) throws SQLException {
        String sql = "SELECT c.course_id, course_name, time, region_id, t.theme_id, t.theme_name, c.url "
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
       
        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {time, region_id});	// JDBCUtil�� query���� �Ű� ���� ����

		try {
		       ResultSet rs = jdbcUtil.executeQuery();      // query ����
		       LinkedHashSet<Integer> courseIdList = new LinkedHashSet<>();

		       while (rs.next()) {
		    	   courseIdList.add(rs.getInt("course_id"));    	  
		       }

	    	   return courseIdList; 
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	//�󼼺���
	public Course detailCourse(int course_id) throws SQLException{
		String sql = "SELECT c.course_id, course_name, departure, stopover, destination, time, parking, region_id, user_id, t.theme_id, t.theme_name, c.url "
	             + "FROM Course c, THEME_COURSE tc, THEME t "
	             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
	             + "AND c.course_id=? ";    
	    
	    jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});   // JDBCUtil�� query���� �Ű� ���� ����


	    try {
	       ResultSet rs = jdbcUtil.executeQuery();      // query ����
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
					rs.getInt("user_id"),
					rs.getString("url")
						);
				
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
			jdbcUtil.close();		// resource ��ȯ
		}
		return null;
	}
	
	   /**
	    * �־��� ����� email�� �ش��ϴ� ����ڰ� �����ϴ��� �˻� 
	    */
	   public boolean existingCourse(String course_name) throws SQLException {
	      String sql = "SELECT count(*) FROM COURSE WHERE course_name=?";      
	      jdbcUtil.setSqlAndParameters(sql, new Object[] {course_name});   // JDBCUtil�� query���� �Ű� ���� ����

	      try {
	         ResultSet rs = jdbcUtil.executeQuery();      // query ����
	         if (rs.next()) {
	            int count = rs.getInt(1);
	            return (count == 1 ? true : false);
	         }
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         jdbcUtil.close();      // resource ��ȯ
	      }
	      return false;
	   }
	   
	   //region_id ������ region�̸� ��ȯ
	   public String regionName(int region_id) throws SQLException {
		      String sql = "SELECT region_name FROM REGION WHERE region_id=?";      
		      jdbcUtil.setSqlAndParameters(sql, new Object[] {region_id});   // JDBCUtil�� query���� �Ű� ���� ����

		      try {
		         ResultSet rs = jdbcUtil.executeQuery();      // query ����
		         if (rs.next()) {
		            String region_name = rs.getString("region_name");
		            return region_name;
		         }
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      } finally {
		         jdbcUtil.close();      // resource ��ȯ
		      }
		      return null;
		 }
	   
	   public List<String> themeName(List<String> themeIdList) throws SQLException {
		      String sql = "SELECT theme_name FROM THEME WHERE theme_id IN (";  
		    	        
		    	        for(String t : themeIdList) {
		    	        	if(t == themeIdList.get(themeIdList.size() - 1)) {
		    	        		sql += (t + ") ");
		    	        		break;
		    	        	}
		    	        	sql += (t + ", ");
		    	        }
		    	        
		      jdbcUtil.setSqlAndParameters(sql, null);   // JDBCUtil�� query���� �Ű� ���� ����

		      try {
		         ResultSet rs = jdbcUtil.executeQuery();      // query ����
		         List<String> themeName = new ArrayList<String>();
		         while (rs.next()) {
		            String theme_name = rs.getString("theme_name");
		            themeName.add(theme_name);
		         }
		         return themeName;
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      } finally {
		         jdbcUtil.close();      // resource ��ȯ
		      }
		      return null;
		 }

	   //��� �߰� �κ�
	   public int countCourse() throws SQLException {
		   String sql = "SELECT COUNT(course_id) AS num FROM COURSE ";
		   jdbcUtil.setSqlAndParameters(sql, null);
		   
		   int courseCount = -1;
		   try {
			   ResultSet rs = jdbcUtil.executeQuery();		// query ����
				if (rs.next()) {						
					courseCount = rs.getInt("num");
					return courseCount;
				}
		   }catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource ��ȯ
			}
		   return courseCount;
	   }
	   
	   public List<Theme> findThemeByCourseId(int course_id) throws SQLException {
		   String sql = "SELECT tc.theme_id, tc.course_id, t.theme_name "
		   		+ "FROM THEME_COURSE tc, THEME t "
		   		+ "WHERE tc.theme_id = t.theme_id "
		   		+ "AND course_id=? ";
		   
		   jdbcUtil.setSqlAndParameters(sql, new Object[] {course_id});
		   
		   List<Theme> themeList = new ArrayList<Theme>();
		   try {
		         ResultSet rs = jdbcUtil.executeQuery();      // query ����
		         while (rs.next()) {
		            int theme_id = rs.getInt("theme_id");
		            String theme_name = rs.getString("theme_name");
		            Theme theme = new Theme(theme_id, theme_name);
		            themeList.add(theme);
		         }
		         return themeList;
		      } catch (Exception ex) {
		         ex.printStackTrace();
		      } finally {
		         jdbcUtil.close();      // resource ��ȯ
		      }
		      return null;
	   }
 public List<Course> findCourseByUserId(int user_id) throws SQLException{
		   String sql ="SELECT c.course_id, course_name, time, region_id, t.theme_id, t.theme_name, c.url "
		             + "FROM Course c, THEME_COURSE tc, THEME t "
		             + "WHERE c.course_id = tc.course_id AND tc.theme_id = t.theme_id "
			   		+ "AND user_id=? ";
			   
			   jdbcUtil.setSqlAndParameters(sql, new Object[] {user_id});
			   
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
									null,
									null,
									null,
									rs.getString("time"),
									0,
									rs.getInt("region_id"),
									themeList,
									0,
									rs.getString("url"));
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

