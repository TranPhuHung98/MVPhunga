package com.example.user.demomvp.Model.database;

import android.database.Cursor;

import com.example.user.demomvp.View.adapter.TenNguoiAdapter;

import java.util.ArrayList;

public interface DataBaseInteractor {

    boolean insertUser(String userName, String userPhone);

    boolean updateUser(String oldUserName, String userName, String userPhone);

    Integer deleteUser(String userName);

    Cursor selectUser();

    void getDataUser(ArrayList arrayList, TenNguoiAdapter adapter);
}
