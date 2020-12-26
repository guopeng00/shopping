package com.example.shoppimg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoppimg.R;
import com.example.shoppimg.bean.ShoppingBean;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class GridlayoutAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper1;
    private ArrayList<ShoppingBean.DataBean.ChannelBean> channelBeans;


    public GridlayoutAdapter(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<ShoppingBean.DataBean.ChannelBean> channelBeans) {
        this.context = context;
        this.gridLayoutHelper1 = gridLayoutHelper;
        this.channelBeans = channelBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_three, null);
        return new Grid1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ShoppingBean.DataBean.ChannelBean channelBean = channelBeans.get(position);
        Grid1ViewHolder holder1= (Grid1ViewHolder) holder;
        holder1.ivHomeGridName.setText(channelBean.getName());
        Glide.with(context).load(channelBean.getIcon_url()).into(holder1.ivHomeGridImg);
    }

    @Override
    public int getItemCount() {
        return channelBeans.size();
    }

    class Grid1ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHomeGridImg;
        private TextView ivHomeGridName;
        public Grid1ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeGridImg = (ImageView) itemView.findViewById(R.id.iv_home_grid_img);
            ivHomeGridName = (TextView) itemView.findViewById(R.id.iv_home_grid_name);
        }
    }
}
