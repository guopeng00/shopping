package com.example.shoppimg;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppimg.fragment.ClassificationFragment;
import com.example.shoppimg.fragment.HomeFragment;
import com.example.shoppimg.fragment.ItsmineFragment;
import com.example.shoppimg.fragment.ShoppingcartFragment;
import com.example.shoppimg.fragment.SpecialFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rvl;
    private RadioGroup radioGroup;
    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button3;
    private RadioButton button4;
    private RadioButton button5;
    private HomeFragment homeFragment;
    private SpecialFragment specialFragment;
    private ArrayList<Fragment> frag;
    private ClassificationFragment classificationFragment;
    private ShoppingcartFragment shoppingcartFragment;
    private ItsmineFragment itsmineFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化页面
        initView();
    }

    private void addFragment(Fragment fragment) {
        //获得Fragment管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        //使用管理器开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //使用事务替换Fragment容器中Fragment对象
        fragmentTransaction.replace(R.id.rvl, fragment);
        //提交事务，否则事务不生效
        fragmentTransaction.commit();
    }

    private void initView() {
        rvl = (RelativeLayout) findViewById(R.id.rvl);
        //找到四个按钮
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button1 = (RadioButton) findViewById(R.id.button_1);
        button2 = (RadioButton) findViewById(R.id.button_2);
        button3 = (RadioButton) findViewById(R.id.button_3);
        button4 = (RadioButton) findViewById(R.id.button_4);
        button5 = (RadioButton) findViewById(R.id.button_5);

        //设置RadioGroup开始时设置的按钮，设置第一个按钮为默认值
        radioGroup.check(R.id.button_1);
        //创建Fragment对象及集合
        homeFragment = new HomeFragment();
        specialFragment = new SpecialFragment();
        classificationFragment = new ClassificationFragment();
        shoppingcartFragment = new ShoppingcartFragment();
        itsmineFragment = new ItsmineFragment();

        //将Fragment对象添加到list中
        frag = new ArrayList<>();
        frag.add(homeFragment);
        frag.add(specialFragment);
        frag.add(classificationFragment);
        frag.add(shoppingcartFragment);
        frag.add(itsmineFragment);

        //设置按钮点击监听
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

        addFragment(homeFragment);
    }

    @Override
    public void onClick(View v) {
//我们根据参数的id区别不同按钮
        //不同按钮对应着不同的Fragment对象页面
        switch (v.getId()) {
            case R.id.button_1:
                addFragment(homeFragment);
                break;
            case R.id.button_2:
                addFragment(specialFragment);
                break;
            case R.id.button_3:
                addFragment(classificationFragment);
                break;
            case R.id.button_4:
                addFragment(shoppingcartFragment);
                break;
            case R.id.button_5:
                addFragment(itsmineFragment);
                break;
            default:
                break;
        }
    }
}