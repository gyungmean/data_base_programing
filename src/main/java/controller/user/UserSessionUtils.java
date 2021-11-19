package controller.user;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "user_id";

    /* 현재 로그인한 사용자의 ID를 구함 */
    public static int getLoginUserId(HttpSession session) {
        int user_id = (int)session.getAttribute(USER_SESSION_KEY);
        return user_id;
    }

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserId(session) > 0) {
            return true;
        }
        return false;
    }

    /* 현재 로그인한 사용자의 ID가 userId인지 검사 */
    public static boolean isLoginUser(int userId, HttpSession session) {
        int loginUser = getLoginUserId(session);
        if (loginUser == 0) {
            return false;
        }
        return (loginUser == userId);
    }
}
