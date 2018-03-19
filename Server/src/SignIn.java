import java.io.Serializable;

public class SignIn implements Serializable {

    private String userNo;
    private String password;

    public SignIn() {
    }

    public SignIn(String userNo, String password) {
        this.userNo = userNo;
        this.password = password;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
