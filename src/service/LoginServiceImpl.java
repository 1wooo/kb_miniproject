package service;

public class LoginServiceImpl implements LoginService {
    private static LoginServiceImpl instance = new LoginServiceImpl();

    // DAO 싱글톤으로 받아와야함.

    private LoginServiceImpl(){}
    public static LoginService getInstance() {
        return instance;
    }

    @Override
    public boolean login(String id, String pw) {
        return false;
    }

    @Override
    public boolean signup(String id, String pw, String nickName) {
        return false;
    }

    @Override
    public void updatePassWord(String passWord) {

    }

    @Override
    public void updateNickName(String nickName) {

    }
}
