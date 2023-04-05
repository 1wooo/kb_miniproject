package dao;

import dto.userdto.UserDTO;

public interface LoginDAO {
    UserDTO loginUser(String id, String pw);

    int signUp(String id, String pw, String nickName);

}
