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
import com.example.user.demomvp.databinding.DialogAddUserBinding;

import java.util.ArrayList;

public class AddUserDialog extends Dialog {
    private DialogAddUserBinding binding;
    private Database database;
    private TenNguoiAdapter adapter;
    private ArrayList<User> arrayList;
    private PresenterMain presenterMain;

    public AddUserDialog(@NonNull Context context, PresenterMain preMain, Database datab, ArrayList arrayL, TenNguoiAdapter adap) {
        super(context);
        this.presenterMain=preMain;
        this.arrayList=arrayL;
        this.adapter = adap;
        this.database=datab;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DialogAddUserBinding.inflate(LayoutInflater.from(getContext()));
        setContentView(binding.getRoot());
    }
    @Override
    public void show(){
        super.show();
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addname = binding.addName.getText().toString();
                String addphone = binding.addPhone.getText().toString();
                if (addname.equals("")){
                    Toast.makeText(getContext(),"Bạn chưa nhập tên", Toast.LENGTH_SHORT).show();
                }else {
                    if (addphone.equals("")) {
                        Toast.makeText(getContext(), "Bạn chưa nhập số", Toast.LENGTH_SHORT).show();
                    } else {
                        presenterMain.insertUserTable(addname, addphone);
                        Toast.makeText(getContext(),"Đã thêm", Toast.LENGTH_SHORT).show();
                        dismiss();
                        presenterMain.getDataUser(arrayList,adapter);
                    }
                }
            }
        });
    }

}
