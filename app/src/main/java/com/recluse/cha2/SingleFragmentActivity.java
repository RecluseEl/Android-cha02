package com.recluse.cha2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/*
*抽象类
* 为了简化代码建立
* 只有一个Fragment的Activity可以继承该类
* 这样就可以用createFragment()来创建Activity视图
* */
public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        //管理Fragment，把他们的视图增加到视图层级结构
        FragmentManager fm=getSupportFragmentManager();
        //从队列里找到目标Fragment
        Fragment fragment=fm.findFragmentById(R.id.fragment_container);
        //比如翻转屏幕，Fragment会被销毁，FragmentManager会保留Fragment队列，这时应新建Fragment增加到原有位置。
        if(fragment==null){
            fragment=createFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }

    }
}
