package com.example.shoppimg.model;

import com.example.mvplibrary.utils.net.INteCallBack;
import com.example.mvplibrary.utils.net.RetrofitUtils;
import com.example.shoppimg.contract.MainContract;

public class MainModel implements MainContract.IModel {
    @Override
    public <T> void getModel(String url, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}
