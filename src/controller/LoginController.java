package controller;

import service.LoginService;
import service.LoginServiceImpl;

public class LoginController {
    // 로그인 서비스 싱글톤으로
    private static LoginService loginService = LoginServiceImpl.getInstance();


    public static void login(String id, String pw) {

    }

    public static void signup(String id, String pw, String nickName) {

    }

    public static void updatePassWord(String passWord) {

    }

    public static void updateNickName(String nickName) {

    }

}
