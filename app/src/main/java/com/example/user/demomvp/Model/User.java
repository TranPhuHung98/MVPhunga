package com.example.user.demomvp.Model;

public class User {
    private String Ten;
    private String SoDT;

    public User(String ten, String soDT) {
        Ten = ten;
        SoDT = soDT;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }
}
