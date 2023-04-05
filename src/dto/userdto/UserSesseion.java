package dto.userdto;

public class UserSesseion {
    private static int uuid;
    private static String userId;

    public UserSesseion() {
    }

    public static int getUuid() {
        return uuid;
    }

    public static void setUuid(int uuid) {
        UserSesseion.uuid = uuid;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserSesseion.userId = userId;
    }
}
