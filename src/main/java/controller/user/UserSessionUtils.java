package controller.user;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "user_id";

    /* ���� �α����� ������� ID�� ���� */
    public static int getLoginUserId(HttpSession session) {
        int user_id = (int)session.getAttribute(USER_SESSION_KEY);
        return user_id;
    }

    /* �α����� ���������� �˻� */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserId(session) > 0) {
            return true;
        }
        return false;
    }

    /* ���� �α����� ������� ID�� userId���� �˻� */
    public static boolean isLoginUser(int userId, HttpSession session) {
        int loginUser = getLoginUserId(session);
        if (loginUser == 0) {
            return false;
        }
        return (loginUser == userId);
    }
}
