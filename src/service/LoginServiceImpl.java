package service;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import dto.userdto.AppUser;
import dto.userdto.UserDTO;
import dto.userdto.UserSesseion;
import exception.DMLException;
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
    public void login(String id, String pw) throws LoginWrongException {

        UserDTO loginUserDTO = loginDAO.loginUser(id, pw);

        if (((AppUser) loginUserDTO).isBanned()) {
            throw new LoginWrongException("Banned User!!");
        }
        UserSesseion sesseion1 = UserSesseion.getInstance();
        sesseion1.setUuid(loginUserDTO.getUuid());
        sesseion1.setNickName(loginUserDTO.getNickname());
        sesseion1.setAdmin(loginUserDTO.isAdmin());
    }

    @Override
    public void signup(String id, String pw, String nickName) throws DMLException {
        int res = loginDAO.signUp(id, pw, nickName);
        if (res == 0) throw new DMLException("회원가입에 오류가 발생했습니다.");
    }

    @Override
    public void updatePassWord(String passWord) {

    }

    @Override
    public void updateNickName(String nickName) {

    }
}
