package com.example.shoppimg.fragment;

import android.view.View;

import com.example.mvplibrary.base.BaseFragment;
import com.example.mvplibrary.base.BasePresenter;
import com.example.shoppimg.R;
import com.example.shoppimg.presenter.MainPresenter;

public class ShoppingcartFragment extends BaseFragment<MainPresenter> {
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

    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_shoppingcart;
    }
}
