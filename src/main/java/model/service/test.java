package model.service;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import model.Course_like;
import model.Region;
import model.Theme;
import model.service.UserManager;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		UserManager manager = UserManager.getInstance();
		Course_likeManager manager1 = Course_likeManager.getInstance();
		
//		User user1 = null;
//		try {
//			user1 = manager.findUser(1);
//		} catch(UserNotFoundException e) {
//			System.out.println("user1 id�� user1 ã�� �����߾�");
//		}
//		
//		System.out.println("user1 ���� : " + user1.toString());
//		
//		User user2 = null;
//		try {
//			user2 = manager.findUserId("a@dongduk.ac.kr");
//		} catch(UserNotFoundException e) {
//			System.out.println("user2 email�� user2 ã�� �����߾�");
//		}
//		
//		System.out.println("user2 ���� : " + user2.toString());
//		
//		User newUser2 = new User(2, "ccc", "c", "c@dongduk.ac.kr");
//		User resultUser2 = null;
//		int result = 0;
//		try {
//			result = manager.update(newUser2);
//			resultUser2 = manager.findUser(2);
//		} catch(UserNotFoundException e) {
//			System.out.println("user2 ���� ����");
//		}
//		
//		System.out.println("newUser2 ���� : " + resultUser2.toString());
//		System.out.println("result : " + result);
		
		
//		boolean result1 = false;
//		boolean result2 = false;
//		try {
//			result1 = manager.login("a@dongduk.ac.kr", "aaa");
//		} catch(Exception e) {
//			System.out.println("result1 �α��� �����߾�");
//		}
//		
//		try {
//			result2 = manager.login("a@dongduk.ac.kr", "bbb");
//		} catch(Exception e) {
//			System.out.println("result2 �α��� �����߾�");
//		}
//		
//		System.out.println("result1 " + result1);
//		System.out.println("result2 " + result2);
		
//		int result3 = 0;
//		try {
//			result3 = manager.remove(1);
//		} catch(Exception e) {
//			System.out.println("result1 ���� �����߾�");
//		}
//		System.out.println("result3 " + result3);
		
//		List<Region> regionList1 = new ArrayList<Region>();
//		List<Region> regionList2 = new ArrayList<Region>();
//		try {
//			regionList1 = manager.regionList(2);
//		} catch(Exception e) {
//			System.out.println("2�� regionList �������� ����");
//		}
//		
//		try {
//			regionList2 = manager.regionList(4);
//		} catch(Exception e) {
//			System.out.println("4�� regionList �������� ����");
//		}
//	
//		System.out.println("2�� regionList : " + regionList1.toString());
//		System.out.println("4�� regionList : " + regionList2.toString());
//		
//		List<Theme> themeList1 = new ArrayList<Theme>();
//		List<Theme> themeList2 = new ArrayList<Theme>();
//		try {
//			themeList1 = manager.themeList(2);
//		} catch(Exception e) {
//			System.out.println("2�� themeList �������� ����");
//		}
//		
//		try {
//			themeList2 = manager.themeList(5);
//		} catch(Exception e) {
//			System.out.println("5�� themeList �������� ����");
//		}
//	
//		System.out.println("2�� themeList : " + themeList1.toString());
//		System.out.println("5�� themeList : " + themeList2.toString());
//		
//		int result5 = 0;
//		User user5 = new User(0, "1111", "newnick", "FFFccc@naver.com");
//		try {
//			result5 = manager.create(user5);
//		} catch(Exception e) {
//			System.out.println("result5 ���� �����߾�");
//		}
//		System.out.println("result5 " + result5);
		
//		int result6 = 0;
//		try {
//			result6 = manager1.createLike(2, 4);
//		} catch(Exception e) {
//			System.out.println("result6 ���� �����߾�");
//		}
//		System.out.println("result6 " + result6);
		
//		int result7 = 0;
//		try {
//			result7 = manager1.removeLike(2, 4);
//		} catch(Exception e) {
//			System.out.println("result7 ���� �����߾�");
//		}
//		System.out.println("result7 " + result7);
		
		int result8 = 0;
		try {
			result8 = manager1.countLike(4);
		} catch(Exception e) {
			System.out.println("result8 ��ȸ �����߾�");
		}
		System.out.println("result8 " + result8);
		
	}

}
