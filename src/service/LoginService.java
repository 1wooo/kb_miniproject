package service;

public interface LoginService {
    boolean login(String id, String pw);

    boolean signup(String id, String pw, String nickName);

    void updatePassWord(String passWord);

    void updateNickName(String nickName);

}
