package com.example.muzammil.prolife.commclasses;

import java.io.Serializable;

public class SignUp implements Serializable {

    private String userNo;
    private String password;
    private String name;
    private byte[] image;
    private String status;

    public SignUp() {
    }

    public SignUp(String userNo, String password, String name, byte[] image, String status) {
        this.userNo = userNo;
        this.password = password;
        this.name = name;
        this.image = image;
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
