package dao;

import common.DBManager;
import dto.userdto.AppUser;
import dto.userdto.UserDTO;
import exception.LoginWrongException;
import exception.SignupWrongException;
import oracle.jdbc.driver.DBConversion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginDAOImpl implements LoginDAO {
    private static LoginDAO instance = new LoginDAOImpl();
    private LoginDAOImpl(){}
    public static LoginDAO getInstance() {
        return instance;
    }

    @Override
    public UserDTO loginUser(String id, String pw) throws LoginWrongException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "select * from userdto where user_id = ? and pass_word = ?";
        UserDTO userDTO = null;

        try {
            con = DBManager.getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, pw);
            rs = st.executeQuery();

            if (rs.next()) {
                int uuid = rs.getInt(1);
                String user_id = rs.getString(2);
                String password = rs.getString(3);
                String nickname = rs.getString(4);
                boolean is_admin = Objects.equals(rs.getString(5), "Y");
                boolean is_banned = Objects.equals(rs.getString(6), "Y");
//                int read_notice_cnt = rs.getInt(7);
                userDTO = new AppUser(uuid, user_id, password, nickname, is_admin, is_banned);
            } else {
                throw new LoginWrongException("아이디 혹은 패스워드가 잘못되었습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginWrongException("로그인 오류");
        } finally {
            DBManager.releaseConnection(con, st, rs);
        }
        return userDTO;
    }

    @Override
    public int signUp(String id, String pw, String nickName) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into USERDTO values (uuid_seq.nextval, ?, ?, ?, ?, ?)";
        int res = 0;

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, pw);
            ps.setString(3, nickName);
            ps.setString(4, "N");
            ps.setString(5, "N");

            res = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SignupWrongException("아이디를 다시 설정해주시기 바랍니다.");
        }finally {
            DBManager.releaseConnection(con, ps);
        }
        return res;
    }
}
