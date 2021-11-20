package model.service;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import model.Course;
import model.Course_like;
import model.Region;
import model.Theme;
import model.service.UserManager;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserManager umanager = UserManager.getInstance();
		Course_likeManager clmanager = Course_likeManager.getInstance();
		CourseManager cmanager = CourseManager.getInstance();
		
		
	
		List<Course> list = new ArrayList<Course>();
		List<Integer> themeList = new ArrayList<Integer>();

		try {
			
			list = clmanager.user_likeCourseList(1);

		} catch(Exception e) {
			System.out.println("실패");
		}
		for(Course l : list) {
			System.out.println(l.toString());
		}
		
//		List<Course> list = new ArrayList<Course>();
//		try {
//			list = cmanager.allCourseList();
//		} catch(Exception e) {
//			System.out.println("코스리스트 찾기 실패");
//		}
//		
//		System.out.println("7번 코스 정보 : " + c.toString());
		
	
//		User newUser2 = new User(2, "ccc", "c", "c@dongduk.ac.kr");
//		User resultUser2 = null;
//		int result = 0;
//		try {
//			result = manager.update(newUser2);
//			resultUser2 = manager.findUser(2);
//		} catch(UserNotFoundException e) {
//			System.out.println("user2 수정 실패");
//		}
//		
//		System.out.println("newUser2 정보 : " + resultUser2.toString());
//		System.out.println("result : " + result);
		
		
//		boolean result1 = false;
//		boolean result2 = false;
//		try {
//			result1 = manager.login("a@dongduk.ac.kr", "aaa");
//		} catch(Exception e) {
//			System.out.println("result1 로그인 실패했어");
//		}
//		
//		try {
//			result2 = manager.login("a@dongduk.ac.kr", "bbb");
//		} catch(Exception e) {
//			System.out.println("result2 로그인 실패했어");
//		}
//		
//		System.out.println("result1 " + result1);
//		System.out.println("result2 " + result2);
		
//		int result3 = 0;
//		try {
//			result3 = manager.remove(1);
//		} catch(Exception e) {
//			System.out.println("result1 삭제 실패했어");
//		}
//		System.out.println("result3 " + result3);
		
//		List<Region> regionList1 = new ArrayList<Region>();
//		List<Region> regionList2 = new ArrayList<Region>();
//		try {
//			regionList1 = manager.regionList(2);
//		} catch(Exception e) {
//			System.out.println("2의 regionList 가져오기 실패");
//		}
//		
//		try {
//			regionList2 = manager.regionList(4);
//		} catch(Exception e) {
//			System.out.println("4의 regionList 가져오기 실패");
//		}
//	
//		System.out.println("2의 regionList : " + regionList1.toString());
//		System.out.println("4의 regionList : " + regionList2.toString());
//		
//		List<Theme> themeList1 = new ArrayList<Theme>();
//		List<Theme> themeList2 = new ArrayList<Theme>();
//		try {
//			themeList1 = manager.themeList(2);
//		} catch(Exception e) {
//			System.out.println("2의 themeList 가져오기 실패");
//		}
//		
//		try {
//			themeList2 = manager.themeList(5);
//		} catch(Exception e) {
//			System.out.println("5의 themeList 가져오기 실패");
//		}
//	
//		System.out.println("2의 themeList : " + themeList1.toString());
//		System.out.println("5의 themeList : " + themeList2.toString());
//		
//		int result5 = 0;
//		User user5 = new User(0, "1111", "newnick", "FFFccc@naver.com");
//		try {
//			result5 = manager.create(user5);
//		} catch(Exception e) {
//			System.out.println("result5 가입 실패했어");
//		}
//		System.out.println("result5 " + result5);
		
//		int result6 = 0;
//		try {
//			result6 = manager1.createLike(2, 4);
//		} catch(Exception e) {
//			System.out.println("result6 삽입 실패했어");
//		}
//		System.out.println("result6 " + result6);
		
//		int result7 = 0;
//		try {
//			result7 = manager1.removeLike(2, 4);
//		} catch(Exception e) {
//			System.out.println("result7 삭제 실패했어");
//		}
//		System.out.println("result7 " + result7);
		
//		int result8 = 0;
//		try {
//			result8 = manager1.countLike(4);
//		} catch(Exception e) {
//			System.out.println("result8 조회 실패했어");
//		}
//		System.out.println("result8 " + result8);
//	
	}

}
