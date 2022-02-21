package model.service;

import model.dao.CourseDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import model.Course;

public class CourseManager {
	/*
	 * create
	 * remove
	 * findCourse / �̸����� �ڽ� ����Ʈ �˻�
	 * allCourseList
	 * matchCourse
	 * courseInfo / �ڽ����̵�� �ڽ� �Ѱ� �˻�
	 * course ������ , spotcourse_like, theme_course, course_comment, course_theme ���� course_id��
	 * ������ �� ��� �����ϰ�
	 * -> �ڽ� ����
	 * */
	
	//theme�̶� like???
	
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
			throw new ExistingCourseException(course.getCourse_name() + "�� �����ϴ� �̸��Դϴ�.");
		}
		int course_id = courseDAO.create(course);
		
		for(int id: theme_id) {
			courseDAO.theme(id, course_id);
		}
		return course_id;
	}
	
	public boolean exist(String course_name) throws SQLException, ExistingCourseException {
		if (courseDAO.existingCourse(course_name) == true) {
			throw new ExistingCourseException(course_name + "�� �����ϴ� �̸��Դϴ�.");
			
		}
		return true;
	}
	
	public int remove(int course_id) throws SQLException, CourseNotFoundException {
		return courseDAO.remove(course_id);
	}
	
	public List<Course> findCourse(String course_name) throws SQLException, CourseNotFoundException {
			List<Course> courseList = courseDAO.findCourse(course_name);
			
			if (courseList == null) {
				throw new CourseNotFoundException("�������� �ʴ� �ڽ��Դϴ�.");
			}		
			return courseList;
	}
	
	
	// ��� �ڽ� ��ȯ
	public List<Course> allCourseList() throws SQLException {
		return courseDAO.allCourseList();

	}
	//��ġ�� �ڽ� ��ȯ
	
	public LinkedHashSet<Integer> matchCourse(String time, int region_id, List<Integer> themeList) throws SQLException {
		List<String> idString = new ArrayList<String>();
		for(int theme :themeList) {
			idString.add(Integer.toString(theme));
		}
		return courseDAO.matchCourse(time, region_id, idString);
	}

	
	// id�� �ڽ� ã�Ƽ� ����
	public Course courseInfo(int course_id) throws SQLException, CourseNotFoundException {
		Course course = courseDAO.detailCourse(course_id);
		
		if (course == null) {
			throw new CourseNotFoundException("�������� �ʴ� �ڽ��Դϴ�.");
		}	
		return course;
		

	}
	
	public String regionName(int region_id) throws SQLException, CourseNotFoundException {	
		return courseDAO.regionName(region_id);
	}
	
	public List<String> themeName(List<String> themeIdList) throws SQLException, CourseNotFoundException {
			return courseDAO.themeName(themeIdList);
	}
	
	//��� �����κ�
	public int countCourse() throws SQLException{
		return courseDAO.countCourse();
	}
	
	public LinkedHashSet<Integer> keywordCourseList(List<String> regionString, List<String> themeString) throws SQLException{
		return courseDAO.keywordCourseList(regionString, themeString);
	}
	
	public LinkedHashSet<Integer> keywordCourseList2(List<String> regionString, List<String> themeString) throws SQLException{
		return courseDAO.keywordCourseList2(regionString, themeString);
	}
	
	public LinkedHashSet<Integer> keywordCourseList3(List<String> regionString, List<String> themeString) throws SQLException{
		return courseDAO.keywordCourseList3(regionString, themeString);
	}
	
	public LinkedHashSet<Integer> notKeywordCourseList(List<String> regionString, List<String> themeString) throws SQLException{
		return courseDAO.notKeywordCourseList(regionString, themeString);
	}
	
	public List<Course> findCourseByUserId(int user_id) throws SQLException{
		return courseDAO.findCourseByUserId(user_id);
	}
}