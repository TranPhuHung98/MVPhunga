package com.example.user.demomvp.View.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.demomvp.Model.User;
import com.example.user.demomvp.databinding.DanhSachNguoiBinding;

import java.util.List;

public class TenNguoiAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private List<User> dataList;
    private OnclickListener listener;

    public TenNguoiAdapter(OnclickListener listener) {
        this.listener = listener;
    }

    public void updateAdapter(List<User> dataList){
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        DanhSachNguoiBinding dsbinding = DanhSachNguoiBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ItemViewHolder(listener,dsbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position){
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount(){
        return dataList==null?0:dataList.size();
    }

    public interface OnclickListener{
        void onNameClick(String txtName, String txtPhone);
    }
}
