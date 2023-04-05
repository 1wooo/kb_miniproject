package dto.userdto;

public class AppUser extends UserDTO {
    private boolean isBanned;
    private int readNoticeCnt;

    public AppUser(int uuid, String userid, String password, String nickname, boolean isAdmin, boolean isBanned, int readNoticeCnt) {
        super(uuid, userid, password, nickname, isAdmin);
        this.isBanned = isBanned;
        this.readNoticeCnt = readNoticeCnt;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public int getReadNoticeCnt() {
        return readNoticeCnt;
    }

    public void setReadNoticeCnt(int readNoticeCnt) {
        this.readNoticeCnt = readNoticeCnt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        sb.append("isBanned=").append(isBanned);
        sb.append(", readNoticeCnt=").append(readNoticeCnt);
        return sb.toString();
    }
}
