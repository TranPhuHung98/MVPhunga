package com.example.user.demomvp.Presenter;

//import com.stdiohe.basestrcuture.ui.adapter.TenNguoiAdapter;

import com.example.user.demomvp.View.adapter.TenNguoiAdapter;

import java.util.ArrayList;

public interface PresenterMain {
    boolean insertUserTable(String userName, String phone);
    boolean updateUser(String oldUserName, String userName, String userPhone);
    int deleteUser(String userName);
    void getDataUser(ArrayList arrayList, TenNguoiAdapter adapter);
}
