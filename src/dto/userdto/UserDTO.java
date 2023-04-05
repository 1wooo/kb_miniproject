package dto.userdto;

public class UserDTO {
    private int uuid;
    private String user_id;
    private String pass_word;
    private String nick_name;
    private boolean isAdmin;
    public UserDTO(){}

    public UserDTO(int uuid, String user_id, String pass_word, String nick_name, boolean isAdmin) {
        this.uuid = uuid;
        this.user_id = user_id;
        this.pass_word = pass_word;
        this.nick_name = nick_name;
        this.isAdmin = isAdmin;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("uuid=").append(uuid);
        sb.append(", userid='").append(userid).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", isAdmin=").append(isAdmin);
        return sb.toString();
    }
}
