package dao;

import common.DBManager;
import dto.userdto.AppUser;
import dto.userdto.UserDTO;
import exception.LoginWrongException;

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
                userDTO = new AppUser(uuid, user_id, password, nickname, is_admin, is_banned, 0);
                System.out.println(((AppUser) userDTO).isBanned());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LoginWrongException("로그인 오류");
        } finally {
            DBManager.releaseConnection(con, st, rs);
        }
        return userDTO;
    }
}
