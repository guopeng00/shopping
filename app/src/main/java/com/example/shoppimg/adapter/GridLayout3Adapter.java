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

public class GridLayout3Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper3;
    private ArrayList<ShoppingBean.DataBean.NewGoodsListBean> newGoodsListBeans;

    public GridLayout3Adapter(Context context, GridLayoutHelper gridLayoutHelper3, ArrayList<ShoppingBean.DataBean.NewGoodsListBean> newGoodsListBeans) {
        this.context = context;
        this.gridLayoutHelper3 = gridLayoutHelper3;
        this.newGoodsListBeans = newGoodsListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_five2, null);
        return new GridLayout3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridLayout3ViewHolder holder1= (GridLayout3ViewHolder) holder;
        ShoppingBean.DataBean.NewGoodsListBean brandListBean = newGoodsListBeans.get(position);
        holder1.tvHomeGird3Name.setText(brandListBean.getName());
        holder1.tvHomeGrid3Sprice.setText("￥"+brandListBean.getRetail_price());
        Glide.with(context).load(brandListBean.getList_pic_url()).into(holder1.ivHomeGrid3Img);
    }

    @Override
    public int getItemCount() {
        return newGoodsListBeans.size();
    }
    class GridLayout3ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHomeGrid3Img;
        private TextView tvHomeGird3Name;
        private TextView tvHomeGrid3Sprice;
        public GridLayout3ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeGrid3Img = (ImageView) itemView.findViewById(R.id.iv_home_grid3_img);
            tvHomeGird3Name = (TextView) itemView.findViewById(R.id.tv_home_gird3_name);
            tvHomeGrid3Sprice = (TextView) itemView.findViewById(R.id.tv_home_grid3_sprice);
        }
    }
}
