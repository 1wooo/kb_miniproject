package dto.userdto;

public class UserSesseion {
    private static UserSesseion instance = new UserSesseion();
    private int uuid;
    private String nickName;
    private boolean isAdmin;

    private UserSesseion() {
    }

    public static UserSesseion getInstance() {
        return instance;
    }

    public void clear() {
        this.uuid = 0;
        this.isAdmin = false;
        this.nickName = "";
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
