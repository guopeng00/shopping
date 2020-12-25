package com.example.shoppimg.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvplibrary.base.BaseFragment;
import com.example.shoppimg.R;
import com.example.shoppimg.adapter.SingleLayoutAdapter;
import com.example.shoppimg.presenter.MainPresenter;

public class HomeFragment extends BaseFragment<MainPresenter> {
    private RecyclerView rlvHome;

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

        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        SingleLayoutAdapter singleLayoutAdapter = new SingleLayoutAdapter(singleLayoutHelper,getActivity());

        DelegateAdapter adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(singleLayoutAdapter);//第一行
        rlvHome.setLayoutManager(virtualLayoutManager);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }
}
