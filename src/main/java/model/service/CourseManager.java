package model.service;

import model.dao.CourseDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;

public class CourseManager {
	/*
	 * create
	 * remove
	 * findCourse / 이름으로 코스 리스트 검색
	 * allCourseList
	 * matchCourse
	 * courseInfo / 코스아이디로 코스 한개 검색
	 * course 삭제시 , spotcourse_like, theme_course, course_comment, course_theme 에서 course_id가
	 * 동일한 행 모두 삭제하고
	 * -> 코스 삭제
	 * */
	
	//theme이랑 like???
	
	private static CourseManager courseMan = new CourseManager();
	private CourseDAO courseDAO;
	
	private CourseManager() {
		try {
			courseDAO = new CourseDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CourseManager getInstance() {
		return courseMan;
	}
	
	public int create(Course course, List<Integer> theme_id) throws SQLException, ExistingCourseException {
		if (courseDAO.existingCourse(course.getCourse_name()) == true) {
			throw new ExistingCourseException(course.getCourse_name() + "는 존재하는 이름입니다.");
		}
		for(int id: theme_id) {
			courseDAO.theme(id,course.getCourse_id());
		}
		return courseDAO.create(course);
	}
	
	public int remove(int course_id) throws SQLException, CourseNotFoundException {
		return courseDAO.remove(course_id);
	}
	
	public List<Course> findCourse(String course_name) throws SQLException, CourseNotFoundException {
			List<Course> courseList = courseDAO.findCourse(course_name);
			
			if (courseList == null) {
				throw new CourseNotFoundException("존재하지 않는 코스입니다.");
			}		
			return courseList;
	}
	
	
	// 모든 코스 반환
	public List<Course> allCourseList() throws SQLException {
		return courseDAO.allCourseList();

	}
	//매치된 코스 반환
	
	public List<Course> matchCourse(String time, int region_id, List<Integer> themeList) throws SQLException {
		List<String> idString = new ArrayList<String>();
		for(int theme :themeList) {
			idString.add(Integer.toString(theme));
		}
		return courseDAO.matchCourse(time, region_id, idString);
	}

	
	// id로 코스 찾아서 리턴
	public Course courseInfo(int course_id) throws SQLException, CourseNotFoundException {
		Course course = courseDAO.detailCourse(course_id);
		
		if (course == null) {
			throw new CourseNotFoundException("존재하지 않는 코스입니다.");
		}	
		return course;
		

	}
	
	public String regionName(int region_id) throws SQLException, CourseNotFoundException {	
		return courseDAO.regionName(region_id);
	}
	
	public List<String> themeName(List<String> themeIdList) throws SQLException, CourseNotFoundException {
			return courseDAO.themeName(themeIdList);
	}
	
	//경민 수정부분
	public int countCourse() throws SQLException{
		return courseDAO.countCourse();
	}
}