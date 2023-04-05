package service;

import dto.userdto.UserDTO;

public interface LoginService {
    UserDTO login(String id, String pw);

    void signup(String id, String pw, String nickName);

    void updatePassWord(String passWord);

    void updateNickName(String nickName);

}
