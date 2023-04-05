package dto.userdto;

public class UserSesseion {
    private int uuid;
    private String nickName;
    private boolean isAdmin;

    public UserSesseion() {
    }

    public UserSesseion(int uuid, String nickName, boolean isAdmin) {
        this.uuid = uuid;
        this.nickName = nickName;
        this.isAdmin = isAdmin;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
