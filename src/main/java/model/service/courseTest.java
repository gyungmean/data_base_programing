package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Theme;

public class courseTest {
   public static void main(String[] args) throws SQLException {
      // TODO Auto-generated method stub
      CourseManager manager = CourseManager.getInstance();
      
//      //create
//      int course1 = 0;
//      List <Theme> themeList = new ArrayList<Theme> ();
//      Course course = new Course(0, "test2",null, null, null, "15��", 0, 1, themeList, 1);
//      try {
//         course1 = manager.create(course);
//      } catch(Exception e) {
//         System.out.println("�ڽ� ���� ����");
//      }
//      System.out.println(course1); //������ generateky��ȯ 
//      
//      //remove
//      int remove = 0;
//      try {
//    	  remove = manager.remove(3);
//      } catch(Exception e) {
//    	  System.out.println("�ڽ� ���� ����");
//      }
//      System.out.println(remove);
      
      //allCourseList
//      List<Course> allCourseList = new ArrayList<Course>();
//      try {
//    	  allCourseList = manager.allCourseList();
//    	  
//    	  for(Course c : allCourseList) {
//    		  System.out.println("�̸�: " + c.getCourse_name());
//    		  System.out.println("�ð�: " + c.getTime());
//    	  }
//      }catch(Exception e) {
//    	  System.out.println("allCourse����");
//      }
      
//      //findCourseById
//      try {
//    	  Course c = manager.findCourseById(4);
//    	  
//    	  System.out.println(c.getCourse_name()); //�ҷ��� �ڽ� ���ӵ� ��� �׽�Ʈ
//    	  System.out.println(c.getRegion_id());
//      }catch(Exception e) {
//    	  System.out.println("allCourse����");
//      }
//      
//      //findCourse
//      List<Course> findCourseList = new ArrayList<Course>();
//      try {
//    	  findCourseList = manager.findCourse("test");
//    	  
//    	  for(Course c : findCourseList) {
//    		  System.out.println(c.getCourse_name()); //�ҷ��� �ڽ� ���ӵ� ��� �׽�Ʈ
//    	  }
//      }catch(Exception e) {
//    	  System.out.println("allCourse����");
//      }
//      
//      //matchCourse
//      //themeList�����ؾ���
//      List <Theme> themeList = new ArrayList<Theme> ();
//      List<Course> matchCourseList = new ArrayList<Course>();
//      try {
//    	  matchCourseList = manager.matchCourse(1, 1, "10��", 2, themeList);
//    	  
//    	  for(Course c : matchCourseList) {
//    		  System.out.println(c.getCourse_name()); //�ҷ��� �ڽ� ���ӵ� ��� �׽�Ʈ
//    	  }
//      }catch(Exception e) {
//    	  System.out.println("allCourse����");
//      }
      
      List<Course> courseList = new ArrayList<Course>();
      List<String> regionString = new ArrayList<String>();
      regionString.add("1");
      List<String> themeString = new ArrayList<String>();
      themeString.add("1");
      themeString.add("2");
      try {
    	  courseList = manager.keywordCourseList(regionString, themeString);
    	  System.out.println(courseList.toString());
    	  
      }catch(Exception e) {
    	  System.out.println("����");
      }
      
   }
}