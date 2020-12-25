package com.example.shoppimg.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvplibrary.base.BaseFragment;
import com.example.shoppimg.R;
import com.example.shoppimg.adapter.SingleLayout2Adapter;
import com.example.shoppimg.adapter.SingleLayoutAdapter;
import com.example.shoppimg.bean.ShoppingBean;
import com.example.shoppimg.contract.MainContract;
import com.example.shoppimg.presenter.MainPresenter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeFragment extends BaseFragment<MainPresenter> implements MainContract.IView {
    private RecyclerView rlvHome;
    private ArrayList<ShoppingBean.DataBean.BannerBean> bannerBeans;
    private SingleLayout2Adapter mAdapter2;
    private SingleLayoutHelper singleLayoutHelper;

    @Override
    protected MainPresenter getPresnter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        presenter.onStart1();
    }

    @Override
    protected void initView(View view) {
        rlvHome = (RecyclerView) view.findViewById(R.id.rlv_home);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        rlvHome.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);

        singleLayoutHelper = new SingleLayoutHelper();
        SingleLayoutAdapter singleLayoutAdapter1 = new SingleLayoutAdapter(getActivity(), singleLayoutHelper);
        bannerBeans = new ArrayList<>();
        mAdapter2 = new SingleLayout2Adapter(getActivity(), singleLayoutHelper, bannerBeans);

        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(singleLayoutAdapter1);//第一行
        adapter.addAdapter(mAdapter2);//第二行
        rlvHome.setLayoutManager(virtualLayoutManager);
        rlvHome.setAdapter(adapter);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onShow(Object object) {
        if(object instanceof ShoppingBean){
            ShoppingBean shoppingBean= (ShoppingBean) object;

        }
    }

    @Override
    public void onHide(String str) {

    }
}
