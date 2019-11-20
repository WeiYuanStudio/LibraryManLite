package club.piclight.LibraryManLite.Model;

public class User {
    private int uid;
    private String username;
    private char gender;
    private String mail;
    private String password;

    public User(int uid, String username, char gender, String mail, String password) {
        this.uid = uid;
        this.username = username;
        this.gender = gender;
        this.mail = mail;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
