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

import java.util.ArrayList;

public class GridLayout5Adapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<ShoppingBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;

    public GridLayout5Adapter(Context context, ArrayList<ShoppingBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans) {
        this.context = context;
        this.goodsListBeans = goodsListBeans;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_eigth2, parent,false);
        return new GridLayout5ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridLayout5ViewHolder holder1= (GridLayout5ViewHolder) holder;
        ShoppingBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsListBeans.get(position);
        holder1.tvHomeGird5Name.setText(goodsListBean.getName());
        holder1.tvHomeGrid5Sprice.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(holder1.ivHomeGrid5Img);

    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size();
    }


    class GridLayout5ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHomeGrid5Img;
        private TextView tvHomeGird5Name;
        private TextView tvHomeGrid5Sprice;
        public GridLayout5ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeGrid5Img = (ImageView) itemView.findViewById(R.id.iv_home_eight2_img);
            tvHomeGird5Name = (TextView) itemView.findViewById(R.id.tv_home_eight2_name);
            tvHomeGrid5Sprice = (TextView) itemView.findViewById(R.id.tv_home_eight2_sprice);
        }
    }
}
