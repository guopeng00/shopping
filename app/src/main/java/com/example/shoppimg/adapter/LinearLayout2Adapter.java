package com.example.shoppimg.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.shoppimg.R;
import com.example.shoppimg.bean.ShoppingBean;
import com.example.shoppimg.contract.MainContract;

import java.util.ArrayList;
import java.util.List;

public class LinearLayout2Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper2;
    private ArrayList<ShoppingBean.DataBean.CategoryListBean> categoryListBeans;
    private GridLayoutHelper gridLayoutHelper5;
    private ArrayList<ShoppingBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;
    private GridLayout5Adapter mAdapterr;
    private DelegateAdapter delegateAdapter;
    private int positionm;


    public LinearLayout2Adapter(Context context, LinearLayoutHelper linearLayoutHelper2, ArrayList<ShoppingBean.DataBean.CategoryListBean> categoryListBeans) {
        this.context = context;
        this.linearLayoutHelper2 = linearLayoutHelper2;
        this.categoryListBeans = categoryListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_eight, parent, false);
        return new Linear2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Linear2ViewHolder holder1= (Linear2ViewHolder) holder;
        ShoppingBean.DataBean.CategoryListBean categoryListBean = categoryListBeans.get(position);
        holder1.tvHomeEightName.setText(categoryListBean.getName());

        goodsListBeans = new ArrayList<>();
        List<ShoppingBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        goodsListBeans.addAll(goodsList);
        GridLayoutManager gridManager = new GridLayoutManager(context,2);
        holder1.rlvHomeLinear.setLayoutManager(gridManager);
        GridLayout5Adapter adapter = new GridLayout5Adapter(context, goodsListBeans);
        holder1.rlvHomeLinear.setAdapter(adapter);
        //改
//        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(context);
//        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
//        holder1.rlvHomeLinear.setRecycledViewPool(recycledViewPool);
//        recycledViewPool.setMaxRecycledViews(0, 10);


//        gridLayoutHelper5 = new GridLayoutHelper(2);

//        mAdapterr = new GridLayout5Adapter(context, gridLayoutHelper5, goodsListBeans);
//        delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
//        delegateAdapter.addAdapter(mAdapterr);
//
//        holder1.rlvHomeLinear.setLayoutManager(virtualLayoutManager);
//        holder1.rlvHomeLinear.setAdapter(delegateAdapter);
//        Linear1ViewHolder holder1= (Linear1ViewHolder) holder;
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
//        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
//        holder1.rlvHomeLinear.setLayoutManager(linearLayoutManager);
//        mAdapter = new Linear11Adapter(context, categoryListBeans);
//        holder1.rlvHomeLinear.setAdapter(mAdapter);
    }

    @Override
    public int getItemCount() {
        if (categoryListBeans.size()>0){
            return categoryListBeans.size();
        }else {
            return 0;
        }
    }

//    @Override
//    public void onShow(Object object) {
//        ShoppingBean shoppingBean= (ShoppingBean) object;
//        List<ShoppingBean.DataBean.CategoryListBean> categoryList = shoppingBean.getData().getCategoryList();
//        categoryListBeans.addAll(categoryList);
//    }

    class Linear2ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rlvHomeLinear;
        TextView tvHomeEightName;
        public Linear2ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHomeEightName = (TextView) itemView.findViewById(R.id.tv_home_eight_name);
            rlvHomeLinear = (RecyclerView) itemView.findViewById(R.id.rlv_home_eight);
        }
    }
}
