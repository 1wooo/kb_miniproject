package dto.userdto;

public class AppUser extends UserDTO {
    private boolean isBanned;
    public AppUser(int uuid, String userid, String password, String nickname, boolean isAdmin, boolean isBanned) {
        super(uuid, userid, password, nickname, isAdmin);
        this.isBanned = isBanned;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("isBanned=").append(isBanned);
        return sb.toString();
    }
}
