package com.example.shoppimg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.shoppimg.R;
import com.example.shoppimg.bean.ShoppingBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class SingleLayout2Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<ShoppingBean.DataBean.BannerBean> bannerBeans;


    public SingleLayout2Adapter(Context context, SingleLayoutHelper singleLayoutHelper, ArrayList<ShoppingBean.DataBean.BannerBean> bannerBeans) {
        this.context = context;
        this.singleLayoutHelper = singleLayoutHelper;
        this.bannerBeans = bannerBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_two, null);
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SingleViewHolder holder1= (SingleViewHolder) holder;
        holder1.myBanner.setImages(bannerBeans).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ShoppingBean.DataBean.BannerBean bannerBean= (ShoppingBean.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class SingleViewHolder extends RecyclerView.ViewHolder {
        private Banner myBanner;
        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            myBanner = (Banner) itemView.findViewById(R.id.my_banner); }
    }
}
