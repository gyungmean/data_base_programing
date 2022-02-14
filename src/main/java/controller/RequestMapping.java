package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.course.*;
import controller.music.AddMusicController;
import controller.music.FindMusicController;
import controller.music.ListMusicController;
import controller.comments.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/main", new MainController());
        mappings.put("/user/login/form", new ForwardController("/user/login.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
//        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());	//마이페이지
        
        // 회원 가입 폼 요청과 가입 요청 처리 병합 (폼에 커뮤니티 선택 메뉴 추가를 위함)
//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
//      mappings.put("/user/register", new RegisterUserController());
        mappings.put("/user/register", new RegisterUserController());

        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        mappings.put("/user/selectKeyword", new KeywordUserController());
        
        // 사용자 정보
        mappings.put("/user/info", new MyPageController());
        
        //코스매칭
        //ListCourseController 전체출력
        mappings.put("/course", new ListCourseController());
        //매칭결과 출력
        mappings.put("/course/course_matching", new MatchCourseController());
        //코스상세보기
        mappings.put("/course/course_detail", new ViewCourseController());
        //코스 좋아요        
        mappings.put("/course/course_like", new LikeCourseController());
        //코스 랭킹 & 검색
        mappings.put("/course/course_rank", new RankCourseController()); 
        mappings.put("/course/search_result", new FindCourseController());
        //코스생성하기
        mappings.put("/course/course_create", new CreateCourseController()); 
        mappings.put("/course/form", new ForwardController("/course/course_create.jsp"));
        
        //게시물 리스트 보여주기
        mappings.put("/comments", new ListCommentsController());
        //게시물 작성하기
        mappings.put("/comments/form", new ForwardController("/comments/comments_write.jsp"));
        mappings.put("/comments/write", new WriteCommentsController());
        //게시물 자세히 보여주기
        mappings.put("/comments/view", new Comment_viewController());
        
        //뮤직 리스트 보여주기
        mappings.put("/music", new ListMusicController());
        mappings.put("/music/form", new ForwardController("/music/music_add.jsp"));
        mappings.put("/music/add", new AddMusicController());
        mappings.put("/music/find", new FindMusicController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
