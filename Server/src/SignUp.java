import java.io.Serializable;

public class SignUp implements Serializable {

    private String userNo;
    private String firstName;
    private String lastName;
    private byte[] image;
    private String status;

    public SignUp() {
    }

    public SignUp(String userNo, String firstName, String lastName, byte[] image, String status) {
        this.userNo = userNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.image = image;
        this.status = status;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
