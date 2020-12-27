package com.example.shoppimg.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvplibrary.base.BaseFragment;
import com.example.shoppimg.R;
import com.example.shoppimg.adapter.GridLayout2Adapter;
import com.example.shoppimg.adapter.GridLayout3Adapter;
import com.example.shoppimg.adapter.GridLayout4Adapter;
import com.example.shoppimg.adapter.GridlayoutAdapter;
import com.example.shoppimg.adapter.LinearLayout1Adapter;
import com.example.shoppimg.adapter.LinearLayout2Adapter;
import com.example.shoppimg.adapter.SingleLayout2Adapter;
import com.example.shoppimg.adapter.SingleLayout3Adapter;
import com.example.shoppimg.adapter.SingleLayout4Adapter;
import com.example.shoppimg.adapter.SingleLayout5Adapter;
import com.example.shoppimg.adapter.SingleLayout6Adapter;
import com.example.shoppimg.adapter.SingleLayoutAdapter;
import com.example.shoppimg.bean.ShoppingBean;
import com.example.shoppimg.contract.MainContract;
import com.example.shoppimg.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<MainPresenter> implements MainContract.IView {
    private RecyclerView rlvHome;
    private ArrayList<ShoppingBean.DataBean.BannerBean> bannerBeans;
    private SingleLayout2Adapter mAdapter2;
    private SingleLayoutHelper singleLayoutHelper1;
    private DelegateAdapter adapter;
    private SingleLayoutAdapter singleLayoutAdapter1;
    private GridLayoutHelper gridLayoutHelper1;
    private ArrayList<ShoppingBean.DataBean.ChannelBean> channelBeans;
    private GridlayoutAdapter mAdapter3;
    private LinearLayoutHelper linearLayoutHelper;
    private SingleLayout3Adapter mAdapter4;
    private SingleLayoutHelper singleLayoutHelper2;
    private SingleLayoutHelper singleLayoutHelper3;
    private GridLayoutHelper gridLayoutHelper2;
    private ArrayList<ShoppingBean.DataBean.BrandListBean> brandListBeans;
    private GridLayout2Adapter mAdapter41;
    private SingleLayoutHelper singleLayoutHelper4;
    private SingleLayout4Adapter mAdapter5;
    private GridLayoutHelper gridLayoutHelper3;
    private ArrayList<ShoppingBean.DataBean.NewGoodsListBean> newGoodsListBeans;
    private GridLayout3Adapter mAdapter51;
    private SingleLayoutHelper singleLayoutHelper5;
    private SingleLayout5Adapter mAdapter6;
    private GridLayoutHelper gridLayoutHelper4;
    private ArrayList<ShoppingBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private GridLayout4Adapter mAdapter61;
    private SingleLayoutHelper singleLayoutHelper6;
    private SingleLayout6Adapter mAdapter7;
    private LinearLayoutHelper linearLayoutHelper1;
    private ArrayList<ShoppingBean.DataBean.TopicListBean> topicListBeans;
    private LinearLayout1Adapter mAdapter71;
    private GridLayoutHelper gridLayoutHelper5;
    private ColumnLayoutHelper columnLayoutHelper1;
    private LinearLayoutHelper linearLayoutHelper2;
    private ArrayList<ShoppingBean.DataBean.CategoryListBean> categoryListBeans;
    private LinearLayout2Adapter mAdapter8;

//    @Override
//    protected MainPresenter getPresnter() {
//        return new MainPresenter();
//    }

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

        singleLayoutHelper1 = new SingleLayoutHelper();
        singleLayoutAdapter1 = new SingleLayoutAdapter(getActivity(), singleLayoutHelper1);
        bannerBeans = new ArrayList<>();

        singleLayoutHelper2 = new SingleLayoutHelper();
        mAdapter2 = new SingleLayout2Adapter(getActivity(), singleLayoutHelper2, bannerBeans);

        gridLayoutHelper1 = new GridLayoutHelper(5);
        channelBeans = new ArrayList<>();
        mAdapter3 = new GridlayoutAdapter(getActivity(), gridLayoutHelper1, channelBeans);


        singleLayoutHelper3 = new SingleLayoutHelper();
        mAdapter4 = new SingleLayout3Adapter(getActivity(), singleLayoutHelper3);
//        mAdapter4 = new LinearAdapter(getActivity(),singleLayoutHelper);

        gridLayoutHelper2 = new GridLayoutHelper(2);
        brandListBeans = new ArrayList<>();
        mAdapter41 = new GridLayout2Adapter(getActivity(), gridLayoutHelper2, brandListBeans);

        singleLayoutHelper4 = new SingleLayoutHelper();
        mAdapter5 = new SingleLayout4Adapter(getActivity(), singleLayoutHelper4);

        gridLayoutHelper3 = new GridLayoutHelper(2);
        newGoodsListBeans = new ArrayList<>();
        mAdapter51 = new GridLayout3Adapter(getActivity(), gridLayoutHelper3, newGoodsListBeans);

        singleLayoutHelper5 = new SingleLayoutHelper();
        mAdapter6 = new SingleLayout5Adapter(getActivity(), singleLayoutHelper5);

        gridLayoutHelper4 = new GridLayoutHelper(1);
        hotGoodsListBeans = new ArrayList<>();
        mAdapter61 = new GridLayout4Adapter(getActivity(), gridLayoutHelper4, hotGoodsListBeans);

        singleLayoutHelper6 = new SingleLayoutHelper();
        mAdapter7 = new SingleLayout6Adapter(getActivity(), singleLayoutHelper6);

        linearLayoutHelper1 = new LinearLayoutHelper();
        gridLayoutHelper5 = new GridLayoutHelper(3);
        columnLayoutHelper1 = new ColumnLayoutHelper();
        topicListBeans = new ArrayList<>();
         mAdapter71= new LinearLayout1Adapter(getActivity(), linearLayoutHelper1, topicListBeans);

        linearLayoutHelper2 = new LinearLayoutHelper();
        categoryListBeans = new ArrayList<>();
        mAdapter8 = new LinearLayout2Adapter(getActivity(), linearLayoutHelper2, categoryListBeans);

        adapter = new DelegateAdapter(virtualLayoutManager, false);
        adapter.addAdapter(singleLayoutAdapter1);//第一行
        adapter.addAdapter(mAdapter2);//第二行
        adapter.addAdapter(mAdapter3);//第三行
        adapter.addAdapter(mAdapter4);//第四行
        adapter.addAdapter(mAdapter41);//第五行
        adapter.addAdapter(mAdapter5);//第五行
        adapter.addAdapter(mAdapter51);//第五行
        adapter.addAdapter(mAdapter6);//第五行
        adapter.addAdapter(mAdapter61);//第五行
        adapter.addAdapter(mAdapter7);//第五行
        adapter.addAdapter(mAdapter71);//第五行
        adapter.addAdapter(mAdapter8);

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
            List<ShoppingBean.DataBean.BannerBean> banner = shoppingBean.getData().getBanner();
            bannerBeans.addAll(banner);
            mAdapter2.notifyDataSetChanged();
            List<ShoppingBean.DataBean.ChannelBean> channel = shoppingBean.getData().getChannel();
            channelBeans.addAll(channel);
            mAdapter3.notifyDataSetChanged();
            List<ShoppingBean.DataBean.BrandListBean> brandList = shoppingBean.getData().getBrandList();
            brandListBeans.addAll(brandList);
            mAdapter41.notifyDataSetChanged();
            List<ShoppingBean.DataBean.NewGoodsListBean> newGoodsList = shoppingBean.getData().getNewGoodsList();
            newGoodsListBeans.addAll(newGoodsList);
            mAdapter51.notifyDataSetChanged();
            List<ShoppingBean.DataBean.HotGoodsListBean> hotGoodsList = shoppingBean.getData().getHotGoodsList();
            hotGoodsListBeans.addAll(hotGoodsList);
            mAdapter61.notifyDataSetChanged();
            List<ShoppingBean.DataBean.TopicListBean> topicList = shoppingBean.getData().getTopicList();
            topicListBeans.addAll(topicList);
            mAdapter71.notifyDataSetChanged();

            List<ShoppingBean.DataBean.CategoryListBean> categoryList = shoppingBean.getData().getCategoryList();
            categoryListBeans.addAll(categoryList);
            mAdapter8.notifyDataSetChanged();
        }

    }

    @Override
    public void onHide(String str) {
        Log.e("TAG", "onHide: "+str );
    }
}
