package controller.course;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Course;
import model.service.CourseManager;
import model.service.Course_likeManager;

public class RankCourseController implements Controller{
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	
		CourseManager manager = CourseManager.getInstance();
		List<Course> courseList = manager.allCourseList();
		Course_likeManager manager2 = Course_likeManager.getInstance();
		
		//course_id�� likecount�� �� 2�����迭
		int[][] tmp;
		
		int courseCount = manager.countCourse();
		tmp = new int[courseCount][2];
		
		//�迭�� �� ����
		for(int i = 0; i < courseCount; i++) {
			int course_id = courseList.get(i).getCourse_id();
			tmp[i][0] = course_id;
			tmp[i][1] = manager2.countLike(course_id);
		}
		
		//likecount�� ���� ����
		Arrays.sort(tmp, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg1[1]-arg0[1];
			}
			
		});
		
		//���ĵ� tmp���� 20���� ��������
		LinkedHashMap<Course, Integer> resultList = new LinkedHashMap<Course, Integer>();
		int count = courseCount < 20 ? courseCount : 20;

		for(int i = 0; i < count; i++) {
			for(Course c : courseList) {
				if(c.getCourse_id() == tmp[i][0]) {
					resultList.put(c, tmp[i][1]);
				}
			}
		}
		
		request.setAttribute("resultList", resultList);
	
		return "/course/course_rank.jsp"; 
    }

}
