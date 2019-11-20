package club.piclight.LibraryManLite.DAO;

import club.piclight.LibraryManLite.Model.User;

public class UserDAO {
    public static User login(String username, String password) {
        User tmpUser = new User(1,
                username,
                'M',
                "gmail",
                "123");
        return tmpUser;
    }
}
