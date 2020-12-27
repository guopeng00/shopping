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
import com.bumptech.glide.Glide;
import com.example.shoppimg.R;
import com.example.shoppimg.bean.ShoppingBean;

import java.util.ArrayList;

public class Linear11Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ShoppingBean.DataBean.TopicListBean> topicListBeans;

    public Linear11Adapter(Context context, ArrayList<ShoppingBean.DataBean.TopicListBean> topicListBeans) {
        this.context = context;
        this.topicListBeans = topicListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_seven3, parent,false);
        return new Linear1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Linear1ViewHolder holder1= (Linear1ViewHolder) holder;
        ShoppingBean.DataBean.TopicListBean brandListBean = topicListBeans.get(position);
        holder1.tvHomeLinear1Name.setText(brandListBean.getTitle());
        holder1.tvHomeLinear1Text.setText(brandListBean.getSubtitle());
        holder1.tvHomeLinear1Sprice.setText("￥"+brandListBean.getPrice_info());
        Glide.with(context).load(brandListBean.getScene_pic_url()).into(holder1.ivHomeLinear1Img);
    }

    @Override
    public int getItemCount() {
        return topicListBeans.size();
    }
    class Linear1ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHomeLinear1Img;
        TextView tvHomeLinear1Name;
        TextView tvHomeLinear1Text;
        TextView tvHomeLinear1Sprice;
        public Linear1ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeLinear1Img = (ImageView) itemView.findViewById(R.id.iv_home_linear1_img);
            tvHomeLinear1Name = (TextView) itemView.findViewById(R.id.tv_home_linear1_name);
            tvHomeLinear1Text = (TextView) itemView.findViewById(R.id.tv_home_linear1_text);
            tvHomeLinear1Sprice = (TextView) itemView.findViewById(R.id.tv_home_linear1_sprice);
        }
    }
}
