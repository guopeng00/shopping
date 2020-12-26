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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoppimg.R;
import com.example.shoppimg.bean.ShoppingBean;

import java.util.ArrayList;

public class LinearLayout1Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper1;
    private ArrayList<ShoppingBean.DataBean.TopicListBean> topicListBeans;

    public LinearLayout1Adapter(Context context, LinearLayoutHelper linearLayoutHelper1, ArrayList<ShoppingBean.DataBean.TopicListBean> topicListBeans) {
        this.context = context;
        this.linearLayoutHelper1 = linearLayoutHelper1;
        this.topicListBeans = topicListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_six2, null);
        return new GridLayout4ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridLayout4ViewHolder holder1= (GridLayout4ViewHolder) holder;
        ShoppingBean.DataBean.HotGoodsListBean brandListBean = hotGoodsListBeans.get(position);
        holder1.tvHomeGird4Name.setText(brandListBean.getName());
        holder1.tvHomeGird4Text.setText(brandListBean.getGoods_brief());
        holder1.tvHomeGrid4Sprice.setText("￥"+brandListBean.getRetail_price());
        Glide.with(context).load(brandListBean.getList_pic_url()).into(holder1.ivHomeGrid4Img);
    }

    @Override
    public int getItemCount() {
        return hotGoodsListBeans.size();
    }
    class GridLayout4ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHomeGrid4Img;
        private TextView tvHomeGird4Name;
        private TextView tvHomeGird4Text;
        private TextView tvHomeGrid4Sprice;
        public GridLayout4ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeGrid4Img = (ImageView) itemView.findViewById(R.id.iv_home_grid4_img);
            tvHomeGird4Name = (TextView) itemView.findViewById(R.id.tv_home_gird4_name);
            tvHomeGird4Text = (TextView) itemView.findViewById(R.id.tv_home_grid4_text);
            tvHomeGrid4Sprice = (TextView) itemView.findViewById(R.id.tv_home_grid4_sprice);
        }
    }
}
