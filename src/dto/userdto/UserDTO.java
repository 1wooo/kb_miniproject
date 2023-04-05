package dto.userdto;

public class UserDTO {
    private int uuid;
    private String userid;
    private String password;
    private String nickname;
    private boolean isAdmin;

    public UserDTO(){}

    public UserDTO(int uuid, String userid, String password, String nickname, boolean isAdmin) {
        this.uuid = uuid;
        this.userid = userid;
        this.password = password;
        this.nickname = nickname;
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
