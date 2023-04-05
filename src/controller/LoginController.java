package controller;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.userdto.UserSesseion;
import exception.LoginWrongException;
import service.LoginService;
import service.LoginServiceImpl;
import view.FailView;

public class LoginController {
    // 로그인 서비스 싱글톤으로
    private static LoginService loginService = LoginServiceImpl.getInstance();
    public static UserSesseion signIn(String id, String pw) throws Exception {
        UserSesseion userSesseion = null;
        try {
            userSesseion = loginService.login(id, pw);
        } catch (RuntimeException e) {
            FailView.errorMessage(e.getMessage());
            throw new Exception();
        }
        return userSesseion;
    }

    public static void signUp(String id, String pw, String nickName) throws Exception {
        try {
            loginService.signup(id, pw, nickName);
        } catch (RuntimeException e) {
            FailView.errorMessage(e.getMessage());
            throw new Exception();
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
