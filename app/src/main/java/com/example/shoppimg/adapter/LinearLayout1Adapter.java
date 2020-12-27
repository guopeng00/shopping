package com.example.shoppimg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.shoppimg.R;
import com.example.shoppimg.bean.ShoppingBean;

import java.util.ArrayList;

public class LinearLayout1Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper1;
    private ArrayList<ShoppingBean.DataBean.TopicListBean> topicListBeans;
    private Linear11Adapter mAdapter;

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
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_seven2, parent,false);
        return new Linear1ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Linear1ViewHolder holder1= (Linear1ViewHolder) holder;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        holder1.rlvHomeLinear.setLayoutManager(linearLayoutManager);
        mAdapter = new Linear11Adapter(context, topicListBeans);
        holder1.rlvHomeLinear.setAdapter(mAdapter);

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class Linear1ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rlvHomeLinear;
        public Linear1ViewHolder(@NonNull View itemView) {
            super(itemView);
            rlvHomeLinear = (RecyclerView) itemView.findViewById(R.id.rlv_home_linear);
        }
    }
}
