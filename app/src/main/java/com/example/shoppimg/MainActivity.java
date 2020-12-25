package com.example.shoppimg;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvl;
    private RadioGroup radioGroup;
    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button3;
    private RadioButton button4;
    private RadioButton button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addFragment();
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
        rvl = (RecyclerView) findViewById(R.id.rvl);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        button1 = (RadioButton) findViewById(R.id.button_1);
        button2 = (RadioButton) findViewById(R.id.button_2);
        button3 = (RadioButton) findViewById(R.id.button_3);
        button4 = (RadioButton) findViewById(R.id.button_4);
        button5 = (RadioButton) findViewById(R.id.button_5);
        radioGroup.check(R.id.button_1);
        
    }
}