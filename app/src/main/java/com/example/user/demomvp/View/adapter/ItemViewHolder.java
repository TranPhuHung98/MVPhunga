package com.example.user.demomvp.View.adapter;

import android.support.v7.widget.RecyclerView;

import com.example.user.demomvp.Model.User;
import com.example.user.demomvp.databinding.DanhSachNguoiBinding;

public class ItemViewHolder extends RecyclerView.ViewHolder implements Item {
    private TenNguoiAdapter.OnclickListener listener;
    private DanhSachNguoiBinding dsbinding;

    public ItemViewHolder(TenNguoiAdapter.OnclickListener listener, DanhSachNguoiBinding dsbinding) {
        super(dsbinding.getRoot());
        this.listener = listener;
        this.dsbinding = dsbinding;
        dsbinding.setEvent(this);
    }

    public void bind(User data){
        dsbinding.setName(data.getTen());
        dsbinding.setSodt(data.getSoDT());
    }

    @Override
    public void onItemClick() {
        listener.onNameClick(dsbinding.getName(),dsbinding.getSodt());
    }

}
