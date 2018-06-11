package com.example.user.demomvp.View.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.user.demomvp.Model.User;
import com.example.user.demomvp.Model.database.dao.Database;
import com.example.user.demomvp.Presenter.PresenterMain;
import com.example.user.demomvp.View.adapter.TenNguoiAdapter;
import com.example.user.demomvp.databinding.DialogUpdelBinding;

import java.util.ArrayList;

public class EditUserDialog extends Dialog  {
    private String userName, phone;
    private DialogUpdelBinding binding;
    private Database database;
    private PresenterMain presenterMain;
    ArrayList<User> arrayList;
    TenNguoiAdapter adapter;

    public EditUserDialog(@NonNull Context context, String name, String phone,PresenterMain preMain, Database datab, ArrayList arrayL, TenNguoiAdapter adap) {
        super(context);
        this.userName = name;
        this.phone = phone;
        this.presenterMain=preMain;
        this.arrayList=arrayL;
        this.adapter = adap;
        this.database = datab;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DialogUpdelBinding.inflate(LayoutInflater.from(getContext()));
        setContentView(binding.getRoot());
    }

    @Override
    public void show() {
        super.show();
        binding.edtname.setText(userName);
        binding.edtphone.setText(phone);
        binding.btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = presenterMain.updateUser(userName,binding.edtname.getText().toString(),binding.edtphone.getText().toString());
                if(isUpdate){
                    Toast.makeText(getContext(),"Đã sửa",Toast.LENGTH_SHORT).show();
                    presenterMain.getDataUser(arrayList,adapter);
                    dismiss();
                }else{
                    Toast.makeText(getContext(),"Không thể sửa",Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isDel = presenterMain.deleteUser(userName);
                if(isDel>0){
                    Toast.makeText(getContext(),"Đã xóa",Toast.LENGTH_SHORT).show();
                    presenterMain.getDataUser(arrayList,adapter);
                    dismiss();
                }else{
                    Toast.makeText(getContext(),"Không thể xóa",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
