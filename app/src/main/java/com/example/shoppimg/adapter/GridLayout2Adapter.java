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

public class GridLayout2Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private GridLayoutHelper gridLayoutHelper2;
    private ArrayList<ShoppingBean.DataBean.BrandListBean> brandListBeans;


    public GridLayout2Adapter(Context context, GridLayoutHelper gridLayoutHelper2, ArrayList<ShoppingBean.DataBean.BrandListBean> brandListBeans) {
        this.context = context;
        this.gridLayoutHelper2 = gridLayoutHelper2;
        this.brandListBeans = brandListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_four2, null);
        return new GridLayout2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridLayout2ViewHolder holder1= (GridLayout2ViewHolder) holder;
        ShoppingBean.DataBean.BrandListBean brandListBean = brandListBeans.get(position);
        holder1.tvHomeGird2Name.setText(brandListBean.getName());
        holder1.tvHomeGrid2Sprice.setText(brandListBean.getFloor_price());
        Glide.with(context).load(brandListBean.getNew_pic_url()).into(holder1.ivHomeGrid2Img);
    }

    @Override
    public int getItemCount() {
        return brandListBeans.size();
    }
    class GridLayout2ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHomeGrid2Img;
        private TextView tvHomeGird2Name;
        private TextView tvHomeGrid2Sprice;
        public GridLayout2ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeGrid2Img = (ImageView) itemView.findViewById(R.id.iv_home_grid2_img);
            tvHomeGird2Name = (TextView) itemView.findViewById(R.id.tv_home_gird2_name);
            tvHomeGrid2Sprice = (TextView) itemView.findViewById(R.id.tv_home_grid2_sprice);
        }
    }
}
