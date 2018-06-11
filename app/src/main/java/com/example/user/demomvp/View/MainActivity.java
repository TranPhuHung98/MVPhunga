package com.example.user.demomvp.View;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.demomvp.Model.User;
import com.example.user.demomvp.Model.database.dao.Database;
import com.example.user.demomvp.Presenter.PresenterMain;
import com.example.user.demomvp.Presenter.PresenterMainImp;
import com.example.user.demomvp.R;
import com.example.user.demomvp.View.adapter.TenNguoiAdapter;
import com.example.user.demomvp.View.dialog.AddUserDialog;
import com.example.user.demomvp.View.dialog.EditUserDialog;
import com.example.user.demomvp.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements TenNguoiAdapter.OnclickListener{
    private ActivityMainBinding binding;
    private Database database;
    ArrayList<User> arrayList;
    TenNguoiAdapter adapter;
    PresenterMain presenterMain;
    private EditUserDialog editUserDialog;
    private AddUserDialog addUserDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    protected void init(){
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        arrayList = new ArrayList<>();
        adapter = new TenNguoiAdapter(this);
        binding.recyclerView.setAdapter(adapter);
        database = new Database(this,"DanhBa.sqlite",null,1);
        presenterMain = new PresenterMainImp(database);
        database.getDataUser(arrayList,adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_user,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuAdd){
            addUserDialog = new AddUserDialog(this,presenterMain,database,arrayList,adapter);
            addUserDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNameClick(String txtName, String txtPhone) {
        editUserDialog = new EditUserDialog(this,txtName,txtPhone,presenterMain,database,arrayList,adapter);
        editUserDialog.show();
    }
}
