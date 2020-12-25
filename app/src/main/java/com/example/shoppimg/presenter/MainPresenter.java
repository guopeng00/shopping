package com.example.shoppimg.presenter;

import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.utils.net.INteCallBack;
import com.example.shoppimg.bean.ShoppingBean;
import com.example.shoppimg.contract.MainContract;
import com.example.shoppimg.model.MainModel;

public class MainPresenter extends BasePresenter<MainContract.IView, MainContract.IModel> implements MainContract.IPresenter {
    @Override
    protected MainContract.IModel getModel() {
        return new MainModel();
    }

    @Override
    public void onStart1() {
        iModel.getModel("index", new INteCallBack<ShoppingBean>() {
            @Override
            public void onSuccess(ShoppingBean shoppingBean) {
                iView.onShow(shoppingBean);
            }

            @Override
            public void onFail(String err) {
                iView.onHide(err);
            }
        });
    }
}
