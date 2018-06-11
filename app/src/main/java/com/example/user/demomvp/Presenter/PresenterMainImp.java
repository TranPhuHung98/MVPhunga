package com.example.user.demomvp.Presenter;

import com.example.user.demomvp.Model.database.DataBaseInteractor;
import com.example.user.demomvp.Model.database.dao.Database;
import com.example.user.demomvp.View.adapter.TenNguoiAdapter;

import java.util.ArrayList;

public class PresenterMainImp implements PresenterMain {
    private DataBaseInteractor database;

    public PresenterMainImp(Database database) {
        this.database=database;
    }

    @Override
    public boolean insertUserTable(String userName, String phone) {
        return database.insertUser(userName,phone);
    }

    @Override
    public boolean updateUser(String oldUserName, String userName, String userPhone) {
        return database.updateUser(oldUserName,userName,userPhone);
    }

    @Override
    public int deleteUser(String userName) {
        return database.deleteUser(userName);
    }

    @Override
    public void getDataUser(ArrayList arrayList, TenNguoiAdapter adapter) {
        database.getDataUser(arrayList,adapter);
    }
}
