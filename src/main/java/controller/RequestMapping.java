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
    
    // �� ��û uri�� ���� controller ��ü�� ������ HashMap ����
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// �� uri�� �����Ǵ� controller ��ü�� ���� �� ����
        mappings.put("/", new ForwardController("index.jsp"));
        mappings.put("/main", new MainController());
        mappings.put("/user/login/form", new ForwardController("/user/login.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
//        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());	//����������
        
        // ȸ�� ���� �� ��û�� ���� ��û ó�� ���� (���� Ŀ�´�Ƽ ���� �޴� �߰��� ����)
//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
//      mappings.put("/user/register", new RegisterUserController());
        mappings.put("/user/register", new RegisterUserController());

        // ����� ���� ���� �� ��û�� ���� ��û ó�� ����
//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        mappings.put("/user/selectKeyword", new KeywordUserController());
        
        // ����� ����
        mappings.put("/user/info", new MyPageController());
        
        //�ڽ���Ī
        //ListCourseController ��ü���
        mappings.put("/course", new ListCourseController());
        //��Ī��� ���
        mappings.put("/course/course_matching", new MatchCourseController());
        //�ڽ��󼼺���
        mappings.put("/course/course_detail", new ViewCourseController());
        //�ڽ� ���ƿ�        
        mappings.put("/course/course_like", new LikeCourseController());
        //�ڽ� ��ŷ & �˻�
        mappings.put("/course/course_rank", new RankCourseController()); 
        mappings.put("/course/search_result", new FindCourseController());
        //�ڽ������ϱ�
        mappings.put("/course/course_create", new CreateCourseController()); 
        mappings.put("/course/form", new ForwardController("/course/course_create.jsp"));
        
        //�Խù� ����Ʈ �����ֱ�
        mappings.put("/comments", new ListCommentsController());
        //�Խù� �ۼ��ϱ�
        mappings.put("/comments/form", new ForwardController("/comments/comments_write.jsp"));
        mappings.put("/comments/write", new WriteCommentsController());
        //�Խù� �ڼ��� �����ֱ�
        mappings.put("/comments/view", new Comment_viewController());
        
        //���� ����Ʈ �����ֱ�
        mappings.put("/music", new ListMusicController());
        mappings.put("/music/form", new ForwardController("/music/music_add.jsp"));
        mappings.put("/music/add", new AddMusicController());
        mappings.put("/music/find", new FindMusicController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// �־��� uri�� �����Ǵ� controller ��ü�� ã�� ��ȯ
        return mappings.get(uri);
    }
}
