package controller;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import exception.LoginWrongException;
import service.LoginService;
import service.LoginServiceImpl;
import view.FailView;

public class LoginController {
    // 로그인 서비스 싱글톤으로
    private static LoginService loginService = LoginServiceImpl.getInstance();
    private static LoginDAO loginDAO = LoginDAOImpl.getInstance();

    public static void signIn(String id, String pw) throws Exception {
        try {
            loginService.login(id, pw);
        } catch (LoginWrongException e) {
            FailView.errorMessage(e.getMessage());
            throw new Exception();
        }
    }

    public static void signUp(String id, String pw, String nickName) {
        try {
            loginService.signup(id, pw, nickName);
        } catch (Exception e) {
            /**
             * 가입시에도 예외처리 필요해보임.
             * ID, PW에 글자수 제한을 두는경우 or 이미 있는 아이디인 경우
             */
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void updatePassWord(String passWord) {

        try {
            loginService.updatePassWord(passWord);
        } catch (Exception e) {
            /**
             * 비밀번호 글자수 제한 예외
             */
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void updateNickName(String nickName) {
        try {
            loginService.updateNickName(nickName);
        } catch (Exception e) {
            /**
             * 닉네임 글자수 제한
             */
            FailView.errorMessage(e.getMessage());
        }
    }

}
