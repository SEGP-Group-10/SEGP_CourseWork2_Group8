package com.example.muzammil.prolife.commclasses; /**
 * Created by Muhammad Usman on 4/3/2018.
 */

import java.io.Serializable;

public class Contact implements Serializable {

    private int id;
    private String Name;
    private String user_No;
    private byte[] image;

    public Contact() {
    }

    public Contact(String name, String user_No, byte[] image) {
        Name = name;
        this.user_No = user_No;
        this.image = image;
    }

    public Contact(int id, String name, String user_No, byte[] image) {
        this.id = id;
        Name = name;
        this.user_No = user_No;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUser_No() {
        return user_No;
    }

    public void setUser_No(String user_No) {
        this.user_No = user_No;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
