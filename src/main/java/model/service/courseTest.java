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
//      Course course = new Course(0, "test2",null, null, null, "15분", 0, 1, themeList, 1);
//      try {
//         course1 = manager.create(course);
//      } catch(Exception e) {
//         System.out.println("코스 생성 실패");
//      }
//      System.out.println(course1); //성공시 generateky반환 
//      
//      //remove
//      int remove = 0;
//      try {
//    	  remove = manager.remove(3);
//      } catch(Exception e) {
//    	  System.out.println("코스 삭제 실패");
//      }
//      System.out.println(remove);
      
      //allCourseList
//      List<Course> allCourseList = new ArrayList<Course>();
//      try {
//    	  allCourseList = manager.allCourseList();
//    	  
//    	  for(Course c : allCourseList) {
//    		  System.out.println("이름: " + c.getCourse_name());
//    		  System.out.println("시간: " + c.getTime());
//    	  }
//      }catch(Exception e) {
//    	  System.out.println("allCourse실패");
//      }
      
//      //findCourseById
//      try {
//    	  Course c = manager.findCourseById(4);
//    	  
//    	  System.out.println(c.getCourse_name()); //불러온 코스 네임들 출력 테스트
//    	  System.out.println(c.getRegion_id());
//      }catch(Exception e) {
//    	  System.out.println("allCourse실패");
//      }
//      
//      //findCourse
//      List<Course> findCourseList = new ArrayList<Course>();
//      try {
//    	  findCourseList = manager.findCourse("test");
//    	  
//    	  for(Course c : findCourseList) {
//    		  System.out.println(c.getCourse_name()); //불러온 코스 네임들 출력 테스트
//    	  }
//      }catch(Exception e) {
//    	  System.out.println("allCourse실패");
//      }
//      
//      //matchCourse
//      //themeList수정해야함
//      List <Theme> themeList = new ArrayList<Theme> ();
//      List<Course> matchCourseList = new ArrayList<Course>();
//      try {
//    	  matchCourseList = manager.matchCourse(1, 1, "10분", 2, themeList);
//    	  
//    	  for(Course c : matchCourseList) {
//    		  System.out.println(c.getCourse_name()); //불러온 코스 네임들 출력 테스트
//    	  }
//      }catch(Exception e) {
//    	  System.out.println("allCourse실패");
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
    	  System.out.println("실패");
      }
      
   }
}