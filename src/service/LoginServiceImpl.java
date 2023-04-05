package service;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.userdto.AppUser;
import dto.userdto.UserDTO;
import exception.LoginWrongException;

public class LoginServiceImpl implements LoginService {
    private static LoginService instance = new LoginServiceImpl();
    private static LoginDAO loginDAO = LoginDAOImpl.getInstance();

    // DAO 싱글톤으로 받아와야함.

    private LoginServiceImpl(){}
    public static LoginService getInstance() {
        return instance;
    }

    @Override
    public UserDTO login(String id, String pw) throws LoginWrongException {
        UserDTO loginUserDTO = loginDAO.loginUser(id, pw);

        if (((AppUser) loginUserDTO).isBanned()) {
            throw new LoginWrongException("Banned User!!");
        }

        return loginUserDTO;
    }

    @Override
    public void signup(String id, String pw, String nickName) {

    }

    @Override
    public void updatePassWord(String passWord) {

    }

    @Override
    public void updateNickName(String nickName) {

    }
}
